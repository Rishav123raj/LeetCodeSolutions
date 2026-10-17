import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    data = world[(world['area'] >= 3000000) | (world['population'] >= 25000000)]
    data = data[['name', 'population', 'area']]
    return data