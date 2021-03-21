class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        temp=dict()
        for task in tasks:
            temp[task]=temp.get(task,0)+1
        flag=dict([(temp[i],i) for i in (temp.keys())])
        maximum=max(temp.values())
        corres=flag[maximum]
        total=sum(temp.values())
        idle=(maximum-1)*n
        b=temp.pop(corres)
        print(b)
        decrease=0
        for i in temp.values():
            if i>maximum-1:
                decrease=decrease+maximum-1
            else:
                decrease=decrease+i
        if idle>=decrease:
            total=total-decrease+idle
        return total

    def leastInterval1(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        temp=dict()
        for task in tasks:
            temp[task]=temp.get(task,0)+1
        maximum=max(temp.values())
        count=0
        for v in temp.values():
            if v==maximum: count=count+1
        return max((maximum-1)*(n+1)+count,len(tasks))
