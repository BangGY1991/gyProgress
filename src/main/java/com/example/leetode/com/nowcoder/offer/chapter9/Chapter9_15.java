package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/11/30 19:17
 * @Version 1.0
 */
public class Chapter9_15 {
    public void pathsToNums(int[] paths) {
        if (paths == null || paths.length == 0) {
            return;
        }
        pathsToDistance(paths);

        distanceToNums(paths);
    }

    private void pathsToDistance(int[] paths) {
        int cap = 0;
        for (int i = 0; i != paths.length; i++) {
            if (paths[i] == i) {
                cap = i;
            } else if (paths[i] > -1) {
                int curI = paths[i];
                paths[i] = -1;
                int preI = i;
                while (paths[curI] != curI) {
                    if (paths[curI] > -1) {
                        int nextI = paths[curI];
                        paths[curI] = preI;
                        preI = curI;
                        curI = nextI;
                    } else {
                        break;
                    }
                }
                int value = paths[curI] == curI ? 0 : paths[curI];
                while (paths[preI] != -1) {
                    int lastPreI = paths[preI];
                    paths[preI] = --value;
                    preI = curI;
                    curI = lastPreI;
                }
                paths[preI] = --value;
            }
        }
        paths[cap] = 0;
    }

    private void distanceToNums(int[] disArr) {
        for (int i = 0; i != disArr.length; i++) {
            int index = disArr[i];
            if (index < 0) {
                disArr[i] = 0;
                while (true) {
                    index = -index;
                    if (disArr[index] > -1) {
                        disArr[index]++;
                        break;
                    } else {
                        int nextIndex = disArr[index];
                        disArr[index] = 1;
                        index = nextIndex;
                    }
                }
            }
        }
        disArr[0] = 1;
    }

}
