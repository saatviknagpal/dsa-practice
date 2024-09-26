class Segment{
    Segment left;
    Segment right;
    int start, end;
    public Segment(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    Segment segment;
    public MyCalendar() {
        segment = new Segment(0, 0);
    }

    public boolean book(int start, int end) {
        return bookAvailable(segment, start, end);
    }
    
    public boolean bookAvailable(Segment segment, int target_s, int target_e){
        int start = segment.start;
        int end = segment.end;
        // valid only when intersection doensn't exist between target range and segment range
        if(target_e <= start){// case 1. if target range is on the left side of the segment range
		    // found empty space
            if(segment.left == null){
               segment.left = new Segment(target_s, target_e); 
               return true;
            }
            return bookAvailable(segment.left, target_s, target_e);
        }
        if(target_s >= end){// case 2. if target range is on the right side of the segment range
		    // found empty space
            if(segment.right == null){ 
               segment.right = new Segment(target_s, target_e); 
               return true;
            }
            return bookAvailable(segment.right, target_s, target_e);
        }
        return false;
    }
}