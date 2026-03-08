
const FAVORITE_KEY = 'country-favorites';

// extrae la data del json que son favorites y retorna un arreglo de ellos  
export function getFavorites():string[]{
  const data = localStorage.getItem(FAVORITE_KEY)
  return data ? JSON.parse(data) : [];
}

// guarda el arreglo de favoritos
export function saveFavorites(codes: string[]): void {
  localStorage.setItem(FAVORITE_KEY,JSON.stringify(codes));
}

expor function toggleFavorites(code: string):boolean{
  const favorites = getFavorites();
  const index = favorites.indexOf(code);

  if(index === -1){
    favorites.push(code);
    saveFavorites(favorites);
    return true
  }else{
    favorites.splice(index,1);
    saveFavorites(favorites);
    return false;
  }
}





