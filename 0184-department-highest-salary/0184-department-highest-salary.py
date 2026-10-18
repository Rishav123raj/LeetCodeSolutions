import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    merged_data = employee.merge(department, left_on='departmentId', right_on='id', how='left')

    highest_salary = merged_data.loc[merged_data.groupby('departmentId')['salary'].transform('max') == merged_data['salary']]

    result = highest_salary[['name_x', 'salary', 'name_y']].rename(columns={
        'name_y': 'Department',
        'name_x': 'Employee',
        'salary': 'Salary'
    })

    return result[['Department', 'Employee', 'Salary']]