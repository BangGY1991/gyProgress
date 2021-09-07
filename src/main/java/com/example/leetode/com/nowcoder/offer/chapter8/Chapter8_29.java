package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 加油站良好出发点问题
 * @author: GuoYu
 * @create: 2021-09-07 15:46
 **/
public class Chapter8_29 {
    public boolean[] stations(int[] dis,int[] oil)
    {
        if (dis == null||oil==null||dis.length<2||dis.length!=oil.length) {
            return null;
        }
        int init=changeDisArrayGetInit(dis,oil);
        return init==-1?new boolean[dis.length]:enlargeArea(dis,init);

    }



    private int changeDisArrayGetInit(int[] dis, int[] oil) {
        int init=-1;
        for (int i = 0; i < dis.length; i++) {
            dis[i]=oil[i]-dis[i];
            if ( dis[i]>=0) {
                init=i;
            }
        }
        return init;

    }
    private boolean[] enlargeArea(int[] dis, int init) {
        boolean[] res=new boolean[dis.length];
        int start=init;
        int end=nextIndex(init,dis.length);
        /*need值为从start位置顺时针扩充连通区的要求，
        rest值为从end位置逆时针扩充连通区的资源。*/
        int need=0;
        int rest=0;
        do {
            //当前来到的start已在连通区域中，可以确定后续的开始点一定无法转完一圈
            if (start!=init&&start==lastIndex(end,dis.length))
            {
                break;
            }
            //当前来到的start不在连通区域中，就扩充连通区域
            if (dis[start]<need){//start无法到达initial点
                need-=dis[start];
            }else {
                rest+=dis[start]-need;
                need=0;
                while (rest>=0&&end!=start)
                {
                    rest+=dis[end];
                    end=nextIndex(end,dis.length);
                }
                //如果连通区域已经覆盖整个环，当前的start是良好出发点
                if (rest>=0){
                    res[start]=true;
                    connectGood(dis,lastIndex(start,dis.length),init,res);
                    break;
                }
            }
            start=lastIndex(start,dis.length);
        }while (start!=init);
        return res;
    }
     /*start如果能够到达良好出发点，那么start出发一定可以换转一圈*/
    private void connectGood(int[] dis, int start, int init, boolean[] res) {
        int need=0;
        while(start!=init)
        {
            if (dis[start]<need) {
                need-=dis[start];
            }else{
                res[start]=true;need=0;
            }
            start=lastIndex(start,dis.length);
        }

    }


    private int lastIndex(int index, int size) {
        return index==0?(size-1):index-1;
    }

    private int nextIndex(int index, int size) {
        return index==size-1?0:(index+1);
    }
}
