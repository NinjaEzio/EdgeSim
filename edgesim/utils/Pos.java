package edgesim.utils;

import java.util.Random;

public class Pos {
    public static void main(String args[])
    {
        Pos pos=new Pos();
        pos.Initialize();
        pos.Search();
    }
    public void Initialize()
    {
        for(int i=0;i<PosNum;i++)
        {
            if(i<PosNum*2/7)
                p_pos[i]=(random.nextDouble()-1)*2;
            else
                p_pos[i]=random.nextDouble()*5;
                p_v[i]=p_best[i]=p_pos[i];
            if(function(g_best)<function(p_best[i]))
            {
                g_best=p_best[i];
            }
        }
    }
    public void Search()
    {
        for(int j=0;j<step;j++)  //����
        {
            for(int i=0;i<PosNum;i++)  //����
            {
                p_v[i]=w*p_v[i]+c1*random.nextDouble()*(p_best[i]-p_pos[i])+c2*random.nextDouble()*(g_best-p_pos[i]);
                if(-2<(p_pos[i]+p_v[i])&&(p_pos[i]+p_v[i])<5)
                    p_pos[i]+=p_v[i];
                if(function(p_best[i])<function(p_pos[i]))
                {
                    p_best[i]=p_pos[i];
                }
                if(function(g_best)<function(p_best[i]))
                {
                    g_best=p_best[i];
                }
                System.out.print(p_pos[i]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(g_best+" "+function(g_best));
    }
    public double function(double x)
    {
        double y=x*x*x-5*x*x-2*x+3;
        return y;
    }
    
    private final int step=100; //��������
    private final int PosNum=70; //������
    private final double w=0.9;//����Ȩ��
    private final double c1=2;//�ֲ�Ȩ�ز���
    private final double c2=2;//ȫ��Ȩ�ز���
    
    private double g_best; //ȫ�����Ž�
    private double p_best[]=new double[PosNum];;//���ӱ�����ʷ���Ž�
    private double[] p_v=new double[PosNum];;//�����ٶ�
    private double[] p_pos=new double[PosNum];//����λ��
    
    private Random random=new Random();

}
