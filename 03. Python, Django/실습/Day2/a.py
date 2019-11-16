
# x = int(input())
# print(x);

# for c in "string":
#     print(c)

# for i in range(0, 5):
#     print(i, i**2)


# # 1. 평균을 구하세요.
# score = {
#     '수학': 80,
#     '국어': 90,
#     '음악': 100
# }

# total_score = sum(score.values())
# print(score.values())
# avg = total_score / len(score)
# print(avg)

# # 2. 반 평균을 구하세요. 전체 평균
# scores = {
#     "a": {
#         "수학": 80,
#         "국어": 90,
#         "음악": 100
#     },
#     "b": {
#         "수학": 80,
#         "국어": 70,
#         "음악": 80
#     }
# }
# a_avg = sum(scores["a"].values()) / len(scores["a"])
# b_avg = sum(scores["b"].values()) / len(scores["b"])
# avg = (a_avg + b_avg) / 2
# print(avg)

city = {
    '서울': [-6, -10, 5],
    '대전': [-3, -5, 2],
    '광주': [0, -2, 10],
    '부산': [2, -2, 9]
}

# 3-1 도시별 최근 3일의 온도 평균은?
for elem in city:
    avg = sum(city[elem]) / len(city[elem])
    print(f"{elem}의 3일 온도 평균: {avg}")
    
# 3-2 위에서 서울은 영상 2도였떤 적이 있나요?
# A if 조건문 else B
print( "있어요" if 2 in city['서울'] else "없어요")

