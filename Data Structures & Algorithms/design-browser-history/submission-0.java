class BrowserHistory {
    //Two Stack Approach
    private Deque<String> forwardStack;
    private Deque<String> backwardStack;
    private String current;

    public BrowserHistory(String homepage) {
        forwardStack = new ArrayDeque<>();
        backwardStack = new ArrayDeque<>();
        current = homepage;
    }
    
    public void visit(String url) {
        backwardStack.push(current);
        current = url;
        forwardStack.clear();
    }
    
    public String back(int steps) {
        while(steps > 0 && !backwardStack.isEmpty()){
            forwardStack.push(current);
            current = backwardStack.pop();
            --steps;
        }

        return current;
    }
    
    public String forward(int steps) {
        while(steps > 0 && !forwardStack.isEmpty()){
            backwardStack.push(current);
            current = forwardStack.pop();
            --steps;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */