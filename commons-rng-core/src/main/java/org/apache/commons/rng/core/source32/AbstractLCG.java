package org.apache.commons.rng.core.source32;

public abstract class AbstractLCG extends IntProvider {
    private long a,c;
    private long m;
    private int seed;
    AbstractLCG()
    {}
    AbstractLCG(long a,long c,long m,int seed)
    {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }
    public int next()
    {
        seed = (int) ((a * seed + c) % m);
        return seed;
    }
}
