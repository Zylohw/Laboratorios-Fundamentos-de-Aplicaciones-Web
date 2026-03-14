import { Button } from '@/components/ui/button';
import type { Property } from '@/types/property';

interface CompareButtonProps {
  property: Property;
  isInCompare: boolean;
  disabled: boolean;
  onAdd: (property: Property) => void;
  onRemove: (id: string) => void;
}

export function CompareButton({ property, isInCompare, disabled, onAdd, onRemove }: CompareButtonProps) {
  const handleClick = () => {
    isInCompare ? onRemove(property.id) : onAdd(property);
  };

  return (
    <Button
      variant={isInCompare ? 'default' : 'outline'}
      size="sm"
      onClick={handleClick}
      disabled={disabled}
      className="w-full"
    >
      {isInCompare ? 'Quitar comparación' : disabled ? 'Límite alcanzado' : 'Comparar'}
    </Button>
  );
}