import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    counts = orders.groupby('customer_number').size().reset_index(name='count')
    results = counts[counts['count'] == counts['count'].max()]
    return results[['customer_number']]
