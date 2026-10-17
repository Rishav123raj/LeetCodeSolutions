import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    data = customers[~customers['id'].isin(orders['customerId'])]
    data = data[['name']].rename(columns={'name': 'Customers'})
    return data