package state;

import state.state.StateMethods;

public class state {

    // methods
    // publish
    // archive
    public interface StateMethods {
        public void publishaction();
        public void archiveaction();
        public void nextaction();
    }

    // states
    // Draft
    // Under Review
    // Published 
    // Archived

    public class Draftstate implements StateMethods {
        private document document;
        public Draftstate(document doc){
            this.document = doc;
        }
        @Override
        public void publishaction() {
            // TODO Auto-generated method stub
            System.err.println("not allowed");
        }
        @Override
        public void archiveaction() {
            // TODO Auto-generated method stub
            System.out.println("not allowed");
        }
        @Override
        public void nextaction() {
            // TODO Auto-generated method stub
            this.document.setstate(new Underreview(document));
            
        }
    }

    public class Underreview implements StateMethods {
        private document document;
        public Underreview(document doc){
            this.document = doc;
        }
        @Override
        public void publishaction() {
            // TODO Auto-generated method stub
            this.document.setstate(new Published(document));
        }
        @Override
        public void archiveaction() {
            // TODO Auto-generated method stub
        }
        @Override
        public void nextaction() {
            // TODO Auto-generated method stub
            
        }
    }

    public class Published implements StateMethods {
        private document document;
        public Published(document doc){
            this.document = doc;
        }
        @Override
        public void publishaction() {
            // TODO Auto-generated method stub
        }
        @Override
        public void archiveaction() {
            // TODO Auto-generated method stub
        }
        @Override
        public void nextaction() {
            // TODO Auto-generated method stub
            
        }
    }

    public class Archived implements StateMethods {
        private document document;
        public Archived(document doc){
            this.document = doc;
        }
        @Override
        public void publishaction() {
            // TODO Auto-generated method stub
        }
        @Override
        public void archiveaction() {
            // TODO Auto-generated method stub
        }
        @Override
        public void nextaction() {
            // TODO Auto-generated method stub
            
        }
    }

}
