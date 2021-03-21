int reverse(int x){
    if(x<10&&x>-10){
        return x;
    }
    if(x>=INT_MAX||x<=INT_MIN){
        return 0;
    }
    bool flag=true;
    if(x<0){
        x=-x;
        flag=false;
    }
    int i=0;
    long long int temp=1;
    while(temp<=x){
        i++;
        temp=temp*10;
    }
    int digits[i];
    temp=1;
    for(int j=0;j<i;j++,temp=temp*10){
        digits[j]=(-x%temp+x%(temp*10))/temp;
    }
    long int sum=0;
    temp=1;
    for(int j=i-1;j>=0;j--,temp=temp*10){
        sum=sum+digits[j]*temp;
    }
    if(sum>=INT_MAX||sum<=INT_MIN){
        return 0;
    }
    if(!flag){
        return -sum;
    }
    return sum;
}
