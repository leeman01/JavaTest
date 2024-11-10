from fastapi import FastAPI

import uvicorn
from pydantic import BaseModel
from starlette.responses import JSONResponse

from chatbot import Chatbot
chatbot = Chatbot()

class Prompt(BaseModel):
    prompt: str

# app 생성
app= FastAPI()

@app.post(path="/getChatbotResponse",status_code=201)
async def getChatbotResponse(prompt: Prompt):
    prompt = dict(prompt)['prompt']
    print(prompt)
    output_dict ={}
    output_dict['chatbotResponse']=chatbot.getResponse(prompt=prompt)
    return JSONResponse(output_dict)

if __name__ == "__main__":
    uvicorn.run(app,host="127.0.0.1", port=8000) # terminal: ./pyapi/main.py