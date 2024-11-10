import openai
from openai import OpenAI

with open('C:/Users/user/Desktop/git/firepunch/TeamProject/pyapi/chatbot_key.txt', 'r') as f:
    chatbot_key = f.read()
# print(chatbot_key)
class Chatbot:
    def __init__(self):
        self.client = OpenAI(api_key=chatbot_key)
        self.system_content ="당신은 무역실무가입니다. 수출 초보 기업의 질문에 대하여 명확한 답을 알려주세요. 한글로 1000자 이내로 대답하세요. 답변 순서는 질문의 핵심 정의, 문제상황, 해결방법, 예시로 합니다."
    
    def getResponse(self, prompt):
        completion = self.client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system", "content": self.system_content},
                {
                    "role": "user",
                    "content": prompt
                }
            ]
        )
        # completion = "챗봇답변"
        # chatbot_response = completion.choices[0].content.strip()
        # print(chatbot_response)
        # print(completion)
        # print(type(completion))
        # print(help(completion))
        content = completion.choices[0].message.content
        return content