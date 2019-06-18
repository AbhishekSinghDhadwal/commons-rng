package org.apache.commons.rng.core.source32;

public class KnuthLewisLCG extends AbstractLCG {
    KnuthLewisLCG(int seed)
    {
        super(1664525,1013904223,4294967296L,seed);
    }
    public static void main(String [] args)
    {
        KnuthLewisLCG a = new KnuthLewisLCG(0);
        for(int i=0;i<10;i++)
        {
            System.out.println(Integer.toHexString(a.next()));
        }
    }
}
