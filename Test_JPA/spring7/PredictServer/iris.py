# package import 

import pandas as pd
import pickle
from sklearn.datasets import load_iris
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split

# 데이터 불러오기
iris = load_iris()

# print(iris)

# 갑작지 잠이온다....

# DataFrame 으로만들기

iris_df = pd.DataFrame(iris['data'],columns=iris['feature_names'])

target = iris['target_names']

print(iris_df)

# x y 처리

X=iris_df
y=iris['target']

#  문제와정답을 분리함ㅌ
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=1)

print(X_train)

#  학습

knn_model = KNeighborsClassifier(n_neighbors=3)

knn_model.fit(X_train,y_train)

#   예츠,ㄱ
knn_model.predict(X_test)


# Score보기
print(knn_model.score(X_test,y_test)) 

pred = knn_model.predict([[5.1,3.5,1.4,0.2]])

print('에측결과: ',target[pred[0]])


# 피클로저장
with open('data.pickle','wb') as f:
    pickle.dump(knn_model,f,pickle.HIGHEST_PROTOCOL)


print('끝!')


# cntrl ~ `(백틱) `
#  cmd : local 설치한 python
# python ./iris.py  --> 실행하라는 의미
#  python (엔터) --> 파이썬 개발을 위한 raw 프로ㅓ그램실행 (x)
















