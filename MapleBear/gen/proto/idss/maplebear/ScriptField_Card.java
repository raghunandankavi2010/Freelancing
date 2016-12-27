/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source Renderscript file: G:\EclipseWorkSpace\MapleBear\src\proto\idss\maplebear\carousel.rs
 */
package proto.idss.maplebear;

import android.renderscript.*;
import android.content.res.Resources;

/**
 * @hide
 */
public class ScriptField_Card extends android.renderscript.Script.FieldBase {
    static public class Item {
        public static final int sizeof = 160;

        Allocation texture;
        Allocation detailTexture;
        Float2 detailTextureOffset;
        Float2 detailLineOffset;
        Float2[] detailTexturePosition;
        Mesh geometry;
        Matrix4f matrix;
        int textureState;
        int detailTextureState;
        int geometryState;
        int cardVisible;
        int detailVisible;
        int shouldPrefetch;
        long textureTimeStamp;
        long detailTextureTimeStamp;
        long geometryTimeStamp;

        Item() {
            detailTextureOffset = new Float2();
            detailLineOffset = new Float2();
            detailTexturePosition = new Float2[2];
            for (int $ct = 0; $ct < 2; $ct++) {
                detailTexturePosition[$ct] = new Float2();
            }

            matrix = new Matrix4f();
        }

    }

    private Item mItemArray[];
    private FieldPacker mIOBuffer;
    private static java.lang.ref.WeakReference<Element> mElementCache = new java.lang.ref.WeakReference<Element>(null);
    public static Element createElement(RenderScript rs) {
        Element.Builder eb = new Element.Builder(rs);
        eb.add(Element.ALLOCATION(rs), "texture");
        eb.add(Element.ALLOCATION(rs), "detailTexture");
        eb.add(Element.F32_2(rs), "detailTextureOffset");
        eb.add(Element.F32_2(rs), "detailLineOffset");
        eb.add(Element.F32_2(rs), "detailTexturePosition", 2);
        eb.add(Element.MESH(rs), "geometry");
        eb.add(Element.MATRIX_4X4(rs), "matrix");
        eb.add(Element.I32(rs), "textureState");
        eb.add(Element.I32(rs), "detailTextureState");
        eb.add(Element.I32(rs), "geometryState");
        eb.add(Element.I32(rs), "cardVisible");
        eb.add(Element.I32(rs), "detailVisible");
        eb.add(Element.I32(rs), "shouldPrefetch");
        eb.add(Element.U32(rs), "#padding_1");
        eb.add(Element.I64(rs), "textureTimeStamp");
        eb.add(Element.I64(rs), "detailTextureTimeStamp");
        eb.add(Element.I64(rs), "geometryTimeStamp");
        return eb.create();
    }

    private  ScriptField_Card(RenderScript rs) {
        mItemArray = null;
        mIOBuffer = null;
        mElement = createElement(rs);
    }

    public  ScriptField_Card(RenderScript rs, int count) {
        mItemArray = null;
        mIOBuffer = null;
        mElement = createElement(rs);
        init(rs, count);
    }

    public  ScriptField_Card(RenderScript rs, int count, int usages) {
        mItemArray = null;
        mIOBuffer = null;
        mElement = createElement(rs);
        init(rs, count, usages);
    }

    public static ScriptField_Card create1D(RenderScript rs, int dimX, int usages) {
        ScriptField_Card obj = new ScriptField_Card(rs);
        obj.mAllocation = Allocation.createSized(rs, obj.mElement, dimX, usages);
        return obj;
    }

    public static ScriptField_Card create1D(RenderScript rs, int dimX) {
        return create1D(rs, dimX, Allocation.USAGE_SCRIPT);
    }

    public static ScriptField_Card create2D(RenderScript rs, int dimX, int dimY) {
        return create2D(rs, dimX, dimY, Allocation.USAGE_SCRIPT);
    }

    public static ScriptField_Card create2D(RenderScript rs, int dimX, int dimY, int usages) {
        ScriptField_Card obj = new ScriptField_Card(rs);
        Type.Builder b = new Type.Builder(rs, obj.mElement);
        b.setX(dimX);
        b.setY(dimY);
        Type t = b.create();
        obj.mAllocation = Allocation.createTyped(rs, t, usages);
        return obj;
    }

    public static Type.Builder createTypeBuilder(RenderScript rs) {
        Element e = createElement(rs);
        return new Type.Builder(rs, e);
    }

    public static ScriptField_Card createCustom(RenderScript rs, Type.Builder tb, int usages) {
        ScriptField_Card obj = new ScriptField_Card(rs);
        Type t = tb.create();
        if (t.getElement() != obj.mElement) {
            throw new RSIllegalArgumentException("Type.Builder did not match expected element type.");
        }
        obj.mAllocation = Allocation.createTyped(rs, t, usages);
        return obj;
    }

    private void copyToArrayLocal(Item i, FieldPacker fp) {
        fp.addObj(i.texture);
        fp.addObj(i.detailTexture);
        fp.addF32(i.detailTextureOffset);
        fp.addF32(i.detailLineOffset);
        for (int ct2 = 0; ct2 < 2; ct2++) {
            fp.addF32(i.detailTexturePosition[ct2]);
        }

        fp.addObj(i.geometry);
        fp.addMatrix(i.matrix);
        fp.addI32(i.textureState);
        fp.addI32(i.detailTextureState);
        fp.addI32(i.geometryState);
        fp.addI32(i.cardVisible);
        fp.addI32(i.detailVisible);
        fp.addI32(i.shouldPrefetch);
        fp.skip(4);
        fp.addI64(i.textureTimeStamp);
        fp.addI64(i.detailTextureTimeStamp);
        fp.addI64(i.geometryTimeStamp);
    }

    private void copyToArray(Item i, int index) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        mIOBuffer.reset(index * Item.sizeof);
        copyToArrayLocal(i, mIOBuffer);
    }

    public synchronized void set(Item i, int index, boolean copyNow) {
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        mItemArray[index] = i;
        if (copyNow)  {
            copyToArray(i, index);
            FieldPacker fp = new FieldPacker(Item.sizeof);
            copyToArrayLocal(i, fp);
            mAllocation.setFromFieldPacker(index, fp);
        }

    }

    public synchronized Item get(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index];
    }

    public synchronized void set_texture(int index, Allocation v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].texture = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 0, fp);
        }

    }

    public synchronized void set_detailTexture(int index, Allocation v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTexture = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 4);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 1, fp);
        }

    }

    public synchronized void set_detailTextureOffset(int index, Float2 v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureOffset = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 8);
            mIOBuffer.addF32(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addF32(v);
            mAllocation.setFromFieldPacker(index, 2, fp);
        }

    }

    public synchronized void set_detailLineOffset(int index, Float2 v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailLineOffset = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 16);
            mIOBuffer.addF32(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addF32(v);
            mAllocation.setFromFieldPacker(index, 3, fp);
        }

    }

    public synchronized void set_detailTexturePosition(int index, Float2[] v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTexturePosition = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 24);
            for (int ct1 = 0; ct1 < 2; ct1++) {
                mIOBuffer.addF32(v[ct1]);
            }

            FieldPacker fp = new FieldPacker(16);
            for (int ct1 = 0; ct1 < 2; ct1++) {
                fp.addF32(v[ct1]);
            }

            mAllocation.setFromFieldPacker(index, 4, fp);
        }

    }

    public synchronized void set_geometry(int index, Mesh v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometry = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 40);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 5, fp);
        }

    }

    public synchronized void set_matrix(int index, Matrix4f v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].matrix = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 44);
            mIOBuffer.addMatrix(v);
            FieldPacker fp = new FieldPacker(64);
            fp.addMatrix(v);
            mAllocation.setFromFieldPacker(index, 6, fp);
        }

    }

    public synchronized void set_textureState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].textureState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 108);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 7, fp);
        }

    }

    public synchronized void set_detailTextureState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 112);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 8, fp);
        }

    }

    public synchronized void set_geometryState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometryState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 116);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 9, fp);
        }

    }

    public synchronized void set_cardVisible(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].cardVisible = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 120);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 10, fp);
        }

    }

    public synchronized void set_detailVisible(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailVisible = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 124);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 11, fp);
        }

    }

    public synchronized void set_shouldPrefetch(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].shouldPrefetch = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 128);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 12, fp);
        }

    }

    public synchronized void set_textureTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].textureTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 136);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 14, fp);
        }

    }

    public synchronized void set_detailTextureTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 144);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 15, fp);
        }

    }

    public synchronized void set_geometryTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometryTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 152);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 16, fp);
        }

    }

    public synchronized Allocation get_texture(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].texture;
    }

    public synchronized Allocation get_detailTexture(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTexture;
    }

    public synchronized Float2 get_detailTextureOffset(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTextureOffset;
    }

    public synchronized Float2 get_detailLineOffset(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailLineOffset;
    }

    public synchronized Float2[] get_detailTexturePosition(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTexturePosition;
    }

    public synchronized Mesh get_geometry(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].geometry;
    }

    public synchronized Matrix4f get_matrix(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].matrix;
    }

    public synchronized int get_textureState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].textureState;
    }

    public synchronized int get_detailTextureState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailTextureState;
    }

    public synchronized int get_geometryState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].geometryState;
    }

    public synchronized int get_cardVisible(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].cardVisible;
    }

    public synchronized int get_detailVisible(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailVisible;
    }

    public synchronized int get_shouldPrefetch(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].shouldPrefetch;
    }

    public synchronized long get_textureTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].textureTimeStamp;
    }

    public synchronized long get_detailTextureTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailTextureTimeStamp;
    }

    public synchronized long get_geometryTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].geometryTimeStamp;
    }

    public synchronized void copyAll() {
        for (int ct = 0; ct < mItemArray.length; ct++) copyToArray(mItemArray[ct], ct);
        mAllocation.setFromFieldPacker(0, mIOBuffer);
    }

    public synchronized void resize(int newSize) {
        if (mItemArray != null)  {
            int oldSize = mItemArray.length;
            int copySize = Math.min(oldSize, newSize);
            if (newSize == oldSize) return;
            Item ni[] = new Item[newSize];
            System.arraycopy(mItemArray, 0, ni, 0, copySize);
            mItemArray = ni;
        }

        mAllocation.resize(newSize);
        if (mIOBuffer != null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
    }

}

