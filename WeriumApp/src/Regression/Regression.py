import numpy as np
import scipy.optimize as op

t = []
ids = []

def f(a,b,x):
    return a + b*x;


coefficients, a = op.curve_fit(f,t, ids)