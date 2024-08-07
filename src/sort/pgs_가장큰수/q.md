# 문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 `[6, 10, 2]`라면 `[6102, 6210, 1062, 1026, 2610, 2106]`를 만들 수 있고, 이중 가장 큰 수는 `6210`입니다.

0 또는 양의 정수가 담긴 배열 `numbers`가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 반환하도록 `solution` 함수를 작성해주세요.

## 제한 사항

- `numbers`의 길이는 1 이상 100,000 이하입니다.
- `numbers`의 원소는 0 이상 1,000 이하입니다.
- 정답이 너무 클 수 있으니 문자열로 바꾸어 반환합니다.

## 입출력 예

| numbers               | return    |
|-----------------------|-----------|
| [6, 10, 2]            | "6210"    |
| [3, 30, 34, 5, 9]     | "9534330" |

## 입출력 예 설명

- **입출력 예 #1**

  주어진 정수가 `[6, 10, 2]`일 때, 이를 이어 붙여 만들 수 있는 가장 큰 수는 `6210`입니다.

- **입출력 예 #2**

  주어진 정수가 `[3, 30, 34, 5, 9]`일 때, 이를 이어 붙여 만들 수 있는 가장 큰 수는 `9534330`입니다.

## 문제 해결 전략

1. 각 숫자를 문자열로 변환합니다.
2. 문자열을 서로 비교하여 더 큰 수가 되도록 정렬합니다.
3. 정렬된 문자열을 이어 붙여 최종 결과를 반환합니다.

이 문제의 핵심은 두 숫자 a와 b를 비교할 때, a+b와 b+a를 비교하여 더 큰 쪽을 선택하는 것입니다. 예를 들어, 숫자 3과 30이 있을 때, "330"과 "303"을 비교하여 더 큰 "330"이 앞에 오도록 합니다.
