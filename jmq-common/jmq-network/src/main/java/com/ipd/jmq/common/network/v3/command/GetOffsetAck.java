package com.ipd.jmq.common.network.v3.command;

import com.ipd.jmq.toolkit.lang.Preconditions;

/**
 * 获取同步位置应答
 */
public class GetOffsetAck extends JMQPayload {
    // 偏移量
    private long offset;
    // 最大偏移量
    private long maxOffset;


    public GetOffsetAck maxOffset(final long maxOffset) {
        setMaxOffset(maxOffset);
        return this;
    }

    public GetOffsetAck offset(final long offset) {
        setOffset(offset);
        return this;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getMaxOffset() {
        return this.maxOffset;
    }

    public void setMaxOffset(long maxOffset) {
        this.maxOffset = maxOffset;
    }

    public int predictionSize() {
        return 16 + 1;
    }

    @Override
    public void validate() {
        Preconditions.checkArgument(offset > 0, "offset must be greater than or equal 0");
        Preconditions.checkArgument(maxOffset > 0, "maxOffset must be greater than or equal 0");
        Preconditions.checkArgument(offset < maxOffset, "maxOffset must be greater than or equal offset");
    }

    @Override
    public int type() {
        return CmdTypes.GET_OFFSET_ACK;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetOffsetAck{");
        sb.append("offset=").append(offset);
        sb.append(", maxOffset=").append(maxOffset);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        GetOffsetAck that = (GetOffsetAck) o;

        if (maxOffset != that.maxOffset) {
            return false;
        }
        if (offset != that.offset) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (offset ^ (offset >>> 32));
        result = 31 * result + (int) (maxOffset ^ (maxOffset >>> 32));
        return result;
    }
}