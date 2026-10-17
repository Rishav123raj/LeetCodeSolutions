import pandas as pd

def find_products(products: pd.DataFrame) -> pd.DataFrame:
    data = products[(products['low_fats'] == 'Y') & (products['recyclable'] == 'Y')]
    data = data[['product_id']]
    return data