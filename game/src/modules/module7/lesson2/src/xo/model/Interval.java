package xo.model;

public class Interval {

    private Integer startIntervalPosition;
    private Integer endIntervalPosition;

    public Integer getStartIntervalPosition() {
        return startIntervalPosition;
    }

    public void setStartIntervalPosition(Integer startIntervalPosition) {
        this.startIntervalPosition = startIntervalPosition;
    }

    public Integer getEndIntervalPosition() {
        return endIntervalPosition;
    }

    public void setEndIntervalPosition(Integer endIntervalPosition) {
        this.endIntervalPosition = endIntervalPosition;
    }

    public void reset()
    {
        startIntervalPosition = null;
        endIntervalPosition = null;
    }

    public int getSize()
    {

        if(startIntervalPosition != null && endIntervalPosition != null)
        {
            return endIntervalPosition - startIntervalPosition + 1;
        }

        return 0;
    }
}

