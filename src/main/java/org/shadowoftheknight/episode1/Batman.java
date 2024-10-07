package org.shadowoftheknight.episode1;

public class Batman {
    public int initialX;
    public int initialY;
    public int actualX;
    public int actualY;
    public int beforeOneX;
    public int beforeOneY;

    public int maxX;
    public int maxY;

    public int minX;
    public int minY;

    public Batman(int initialX, int initialY){
        this.initialX = initialX;
        this.initialY = initialY;

        System.err.println("initialX: " + initialX);
        System.err.println("initialY: " + initialY);
    }

    public Batman(){}

    public void updateCoordinates(Bomb bomb){
        if(bomb.actualDir.contains(bomb.DOWN)){
            if(bomb.beforeDir.contains(bomb.UP)){
                this.maxY = this.beforeOneY;
                this.minY = this.actualY;
            }
            if(this.actualY == this.beforeOneY) {
                this.actualY = this.actualY + 1;
            }else {
                this.updateBeforeY();
                this.actualY = Math.round(this.actualY + (this.maxY - this.actualY)/2);
            }
        }

        if(bomb.actualDir.contains(bomb.UP)){
            if(bomb.beforeDir.contains(bomb.DOWN)) {
                this.maxY = this.actualY;
                this.minY = this.beforeOneY;
            }
            if(this.actualY == this.beforeOneY) {
                this.actualY = this.actualY - 1;
            }else{
                this.updateBeforeY();
                if(!(this.actualY % 2 == 0)) this.actualY = this.actualY - 1;
                this.actualY = Math.round(this.actualY - (this.actualY - this.minY)/2);
            }
        }

        if(bomb.actualDir.contains(bomb.LEFT)){
            if(bomb.beforeDir.contains(bomb.RIGHT)){
                this.minX = this.beforeOneX;
                this.maxX = this.actualX;
            }
            if(this.actualX == this.beforeOneX) {
                this.actualX = this.actualX - 1;
            }else{
                this.updateBeforeX();
                if(!(this.actualX % 2 == 0)) this.actualX = this.actualX - 1;
                this.actualX = Math.round(this.actualX - (this.actualX - this.minX)/2);
            }
        }

        if(bomb.actualDir.contains(bomb.RIGHT)){
            if(bomb.beforeDir.contains(bomb.LEFT)){
                this.maxX = this.beforeOneX;
                this.minX = this.actualX;
            }

            System.err.println("maxX: " + this.maxX);

            if(this.actualX == this.beforeOneX) {
                this.actualX = this.actualX + 1;
            }else{
                this.updateBeforeX();
                this.actualX = Math.round(this.actualX + (this.maxX - this.actualX)/2);
            }
        }
    }

    private void updateBeforeX(){
        this.beforeOneX = this.actualX;
    }

    private void updateBeforeY(){
        this.beforeOneY = this.actualY;
    }
}
