package al_22_06;
import java.util.*;

/*
* 위키백과, 우리 모두의 백과사전.

Examples for calculating the square root of 2 with Heron's method.svg
바빌로니아 법(The Babylonian Method)은 임의의 수의 제곱근에 빠르게 수렴하는 수열을 만들어 근삿값을 구하는 방법이다. 뉴턴랩슨 법을 이용하여 이차방정식의 근사해를 구하는 것과 유사하다. 헤론의 저서에서 바빌로니아 법과 비슷한 형태의 풀이가 제시되었기 때문에 바빌로니아 법을 헤론의 제곱근 풀이법이라고 하기도 한다.

양의 실수 {\displaystyle a}a에 대하여 다음 과정을 따라 {\displaystyle {\sqrt {a}}}\sqrt{a}의 근삿값을 구할 수 있다.

임의의 양의 실수 {\displaystyle x_{0}}x_0를 택한다. 이 값이 {\displaystyle {\sqrt {a}}}\sqrt{a}에 가까울수록 더 빨리 근삿값을 구할 수 있다.
{\displaystyle x_{n+1}={\frac {1}{2}}\left(x_{n}+{\frac {a}{x_{n}}}\right)={\frac {{x_{n}}^{2}+a}{2x_{n}}}}{\displaystyle x_{n+1}={\frac {1}{2}}\left(x_{n}+{\frac {a}{x_{n}}}\right)={\frac {{x_{n}}^{2}+a}{2x_{n}}}}
원하는 정밀도에 이르기까지 2의 과정을 반복한다.
위에서 구한 수열 {\displaystyle \left\{x_{n}\right\}}{\displaystyle \left\{x_{n}\right\}}에서 각 항은 이전 항에 비해 소수점 아래로 두 배의 유효 수치를 갖는 것으로 알려져 있으며, {\displaystyle \lim _{n\to \infty }x_{n}={\sqrt {a}}}{\displaystyle \lim _{n\to \infty }x_{n}={\sqrt {a}}}를 만족한다.

다음은 {\displaystyle x_{0}=1}{\displaystyle x_{0}=1}로 시작하여 위의 방법에 따라 {\displaystyle {\sqrt {2}}}{\sqrt {2}}의 근삿값을 구한 것이다.

{\displaystyle x_{1}={\frac {3}{2}}=1.5}{\displaystyle x_{1}={\frac {3}{2}}=1.5}
{\displaystyle x_{2}={\frac {17}{12}}=1.41{\dot {6}}}{\displaystyle x_{2}={\frac {17}{12}}=1.41{\dot {6}}}
{\displaystyle x_{3}={\frac {577}{408}}\approx 1.4142156862~7450980392~1568627451}{\displaystyle x_{3}={\frac {577}{408}}\approx 1.4142156862~7450980392~1568627451}
{\displaystyle x_{4}={\frac {665857}{470832}}\approx 1.4142135623~7468991062~6295578890~1}{\displaystyle x_{4}={\frac {665857}{470832}}\approx 1.4142135623~7468991062~6295578890~1}
{\displaystyle x_{5}={\frac {886731088897}{627013566048}}\approx 1.4142135623~7309504880~16896235}{\displaystyle x_{5}={\frac {886731088897}{627013566048}}\approx 1.4142135623~7309504880~16896235}
* */
public class 바빌로니아법 {

    public class Solution {
        public String computeSquareRoot(int num) {
            // TODO:
            return String.format("%.2f",sqrt(num));
        }

        public double sqrt(int num){
            double x = num/2;

            for (int i = 0; i < 5; i++){
                x = (x + (num/x)) / 2;
            }
            return x;
        }
    }

}
