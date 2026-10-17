import pandas as pd

def invalid_tweets(tweets: pd.DataFrame) -> pd.DataFrame:
    data = tweets[tweets['content'].str.len() > 15]
    data = data[['tweet_id']]
    return data