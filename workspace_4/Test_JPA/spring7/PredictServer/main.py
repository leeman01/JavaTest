# 필요한 패키지 임포트
import pandas as pd
import numpy as np
import pickle

from fastapi import FastAPI
# pip install fastapi 'uvicorn[standard]' 를 먼저 설치해야 합니다.
import uvicorn
from pydantic import BaseModel
from starlette.responses import JSONResponse

# 모델 생성
class Item(BaseModel):
    petalLength: float
    petalWidth: float
    sepalLength: float
    sepalWidth: float

app = FastAPI()

@app.post(path="/items", status_code=201)
def myiris(item: Item):
    # 학습모델 로딩(피클 파일)
    with open('./data.pickle', 'rb') as f:
        knn_model = pickle.load(f)
        
    dicted = item.dict()  # BaseModel 객체를 딕셔너리로 변환

    petalLength = dicted['petalLength']
    petalWidth = dicted['petalWidth']
    sepalLength = dicted['sepalLength']
    sepalWidth = dicted['sepalWidth']
    
    # 분석하기 위한 2차원 데이터로 변경 (수정)
    X = np.array([[sepalLength, sepalWidth, petalLength, petalWidth]])  # 배열 생성 시 () 대신 []

    target = ['setosa', 'versicolor', 'virginica']

    pred = knn_model.predict(X)
    
    result = {"predict_result": target[pred[0]]}  # 결과 사전 생성 (수정)

    print("===========예측 반환값===========================", pred)
    print("===========예측 결과값===========================", result)

    return JSONResponse(result)

if __name__ == '__main__':
    uvicorn.run(app, host="127.0.0.1", port=8000)
