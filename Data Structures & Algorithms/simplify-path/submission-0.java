class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        for(String part : path.split("/")){
            if(part.isEmpty() || part.equals(".")){
                continue;
            }

            if(part.equals("..")){
                if(!st.isEmpty()) st.removeLast();
            }else {
                st.addLast(part);
            }
        }

        if(st.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append("/").append(st.removeFirst());
        }

        return res.toString();
    }
}
