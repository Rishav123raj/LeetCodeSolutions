import pandas as pd

def find_patients(patients: pd.DataFrame) -> pd.DataFrame:
    patients_with_diabetes = patients[patients['conditions'].str.contains(r'(^|\s)DIAB1', na=False)]
    return patients_with_diabetes