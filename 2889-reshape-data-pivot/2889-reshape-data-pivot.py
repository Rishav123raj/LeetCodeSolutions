import pandas as pd

def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
    ans = weather.pivot(index='month', columns='city', values='temperature')
    # month_order = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    # ans = ans.reindex(month_order)
    return ans