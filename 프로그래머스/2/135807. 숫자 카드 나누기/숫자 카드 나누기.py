import math

def solution(arrayA, arrayB):
    return max(cal(arrayA, arrayB), cal(arrayB, arrayA))


def cal(arrayA, arrayB):
    gcd = arrayA[0]

    # 모든 숫자의 최대공약수
    for a in arrayA:
        gcd = math.gcd(gcd, a)

    # 상대 배열에 나누어떨어지는 값이 있으면 실패
    for b in arrayB:
        if b % gcd == 0:
            return 0

    return gcd