import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    employees['bonus'] = employees['salary'].where(
        (employees['employee_id'] % 2 != 0) &
        (~employees['name'].str.startswith('M')),
        0
    )
    employees = employees[['employee_id', 'bonus']]
    employees = employees.sort_values(by='employee_id')
    return employees