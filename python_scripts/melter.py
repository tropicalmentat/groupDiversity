# Small script to create test dataset for group optimization

import pandas as pd

data = r'C:\Users\jose.luigi.s.torres\Desktop\trulyhuman_grouper\data\data_th_heart_melted.csv'

df = pd.read_csv(data)

new_idx = df.set_index('name')

stacked = new_idx.stack().reset_index()

data = r'C:\Users\jose.luigi.s.torres\Desktop\trulyhuman_grouper\data\\'

new_idx[['hobbies_Reading','hobbies_Volunteering']].to_csv(data+r'sample_hobbies.csv')

print('Done!')