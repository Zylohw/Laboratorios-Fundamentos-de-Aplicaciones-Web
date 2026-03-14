import { Link } from 'react-router-dom';
import { Button } from '@/components/ui/button';
import { formatPrice, formatArea } from '@/lib/utils';
import { PROPERTY_TYPE_LABELS } from '@/types/property';
import type { Property } from '@/types/property';

interface ComparePageProps {
  compareList: Property[];
  onRemove: (id: string) => void;
}

export function ComparePage({ compareList, onRemove }: ComparePageProps) {
  if (compareList.length === 0) {
    return (
      <div className="container mx-auto px-4 py-16 text-center">
        <h1 className="text-2xl font-bold mb-4">Comparar propiedades</h1>
        <p className="text-muted-foreground mb-6">No has seleccionado propiedades para comparar.</p>
        <Button asChild><Link to="/">Ver propiedades</Link></Button>
      </div>
    );
  }

  const lowestPrice = Math.min(...compareList.map(p => p.price));
  const highestArea = Math.max(...compareList.map(p => p.area));

  const rows = [
    { label: 'Tipo', render: (p: Property) => PROPERTY_TYPE_LABELS[p.propertyType] },
    { label: 'Precio', render: (p: Property) => (
      <span className={p.price === lowestPrice ? 'text-green-600 font-bold' : ''}>
        {formatPrice(p.price)}
      </span>
    )},
    { label: 'Habitaciones', render: (p: Property) => p.bedrooms },
    { label: 'Baños', render: (p: Property) => p.bathrooms },
    { label: 'Área', render: (p: Property) => (
      <span className={p.area === highestArea ? 'text-green-600 font-bold' : ''}>
        {formatArea(p.area)}
      </span>
    )},
    { label: 'Precio/m²', render: (p: Property) => `$${Math.round(p.price / p.area).toLocaleString()}` },
    { label: 'Ciudad', render: (p: Property) => p.city },
  ];

  return (
    <div className="container mx-auto px-4 py-8">
      <div className="flex items-center justify-between mb-6">
        <h1 className="text-2xl font-bold">Comparar propiedades</h1>
        <Button variant="outline" asChild><Link to="/">← Volver</Link></Button>
      </div>
      <div className="overflow-x-auto">
        <table className="w-full border-collapse">
          <thead>
            <tr>
              <th className="text-left p-3 bg-muted w-32">Característica</th>
              {compareList.map(p => (
                <th key={p.id} className="p-3 bg-muted text-center">
                  <div className="font-semibold">{p.title}</div>
                  <Button variant="ghost" size="sm" className="text-destructive mt-1" onClick={() => onRemove(p.id)}>
                    Quitar
                  </Button>
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {rows.map(row => (
              <tr key={row.label} className="border-t">
                <td className="p-3 text-muted-foreground text-sm font-medium">{row.label}</td>
                {compareList.map(p => (
                  <td key={p.id} className="p-3 text-center">{row.render(p)}</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
