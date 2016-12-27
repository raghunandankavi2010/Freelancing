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
public class ScriptC_carousel extends ScriptC {
    private static final String __rs_resource_name = "carousel";
    // Constructor
    public  ScriptC_carousel(RenderScript rs) {
        this(rs,
             rs.getApplicationContext().getResources(),
             rs.getApplicationContext().getResources().getIdentifier(
                 __rs_resource_name, "raw",
                 rs.getApplicationContext().getPackageName()));
    }

    public  ScriptC_carousel(RenderScript rs, Resources resources, int id) {
        super(rs, resources, id);
        mExportVar_debugCamera = false;
        mExportVar_debugSelection = false;
        mExportVar_debugTextureLoading = false;
        mExportVar_debugGeometryLoading = false;
        mExportVar_debugDetails = false;
        mExportVar_debugRendering = false;
        mExportVar_debugRays = false;
        mExportVar_dragModel = 0;
    }

    private FieldPacker __rs_fp_ALLOCATION;
    private FieldPacker __rs_fp_BOOLEAN;
    private FieldPacker __rs_fp_F32;
    private FieldPacker __rs_fp_F32_4;
    private FieldPacker __rs_fp_I32;
    private FieldPacker __rs_fp_MESH;
    private FieldPacker __rs_fp_PROGRAM_FRAGMENT;
    private FieldPacker __rs_fp_PROGRAM_RASTER;
    private FieldPacker __rs_fp_PROGRAM_STORE;
    private FieldPacker __rs_fp_PROGRAM_VERTEX;
    private FieldPacker __rs_fp_SAMPLER;
    private final static int mExportVarIdx_debugCamera = 0;
    private boolean mExportVar_debugCamera;
    public final static boolean const_debugCamera = false;
    public boolean get_debugCamera() {
        return mExportVar_debugCamera;
    }

    private final static int mExportVarIdx_debugSelection = 1;
    private boolean mExportVar_debugSelection;
    public final static boolean const_debugSelection = false;
    public boolean get_debugSelection() {
        return mExportVar_debugSelection;
    }

    private final static int mExportVarIdx_debugTextureLoading = 2;
    private boolean mExportVar_debugTextureLoading;
    public final static boolean const_debugTextureLoading = false;
    public boolean get_debugTextureLoading() {
        return mExportVar_debugTextureLoading;
    }

    private final static int mExportVarIdx_debugGeometryLoading = 3;
    private boolean mExportVar_debugGeometryLoading;
    public final static boolean const_debugGeometryLoading = false;
    public boolean get_debugGeometryLoading() {
        return mExportVar_debugGeometryLoading;
    }

    private final static int mExportVarIdx_debugDetails = 4;
    private boolean mExportVar_debugDetails;
    public final static boolean const_debugDetails = false;
    public boolean get_debugDetails() {
        return mExportVar_debugDetails;
    }

    private final static int mExportVarIdx_debugRendering = 5;
    private boolean mExportVar_debugRendering;
    public final static boolean const_debugRendering = false;
    public boolean get_debugRendering() {
        return mExportVar_debugRendering;
    }

    private final static int mExportVarIdx_debugRays = 6;
    private boolean mExportVar_debugRays;
    public final static boolean const_debugRays = false;
    public boolean get_debugRays() {
        return mExportVar_debugRays;
    }

    private final static int mExportVarIdx_cards = 7;
    private ScriptField_Card mExportVar_cards;
    public void bind_cards(ScriptField_Card v) {
        mExportVar_cards = v;
        if (v == null) bindAllocation(null, mExportVarIdx_cards);
        else bindAllocation(v.getAllocation(), mExportVarIdx_cards);
    }

    public ScriptField_Card get_cards() {
        return mExportVar_cards;
    }

    private final static int mExportVarIdx_startAngle = 8;
    private float mExportVar_startAngle;
    public synchronized void set_startAngle(float v) {
        setVar(mExportVarIdx_startAngle, v);
        mExportVar_startAngle = v;
    }

    public float get_startAngle() {
        return mExportVar_startAngle;
    }

    private final static int mExportVarIdx_slotCount = 9;
    private int mExportVar_slotCount;
    public synchronized void set_slotCount(int v) {
        setVar(mExportVarIdx_slotCount, v);
        mExportVar_slotCount = v;
    }

    public int get_slotCount() {
        return mExportVar_slotCount;
    }

    private final static int mExportVarIdx_cardCount = 10;
    private int mExportVar_cardCount;
    public synchronized void set_cardCount(int v) {
        setVar(mExportVarIdx_cardCount, v);
        mExportVar_cardCount = v;
    }

    public int get_cardCount() {
        return mExportVar_cardCount;
    }

    private final static int mExportVarIdx_programStoresCardCount = 11;
    private int mExportVar_programStoresCardCount;
    public synchronized void set_programStoresCardCount(int v) {
        setVar(mExportVarIdx_programStoresCardCount, v);
        mExportVar_programStoresCardCount = v;
    }

    public int get_programStoresCardCount() {
        return mExportVar_programStoresCardCount;
    }

    private final static int mExportVarIdx_visibleSlotCount = 12;
    private int mExportVar_visibleSlotCount;
    public synchronized void set_visibleSlotCount(int v) {
        setVar(mExportVarIdx_visibleSlotCount, v);
        mExportVar_visibleSlotCount = v;
    }

    public int get_visibleSlotCount() {
        return mExportVar_visibleSlotCount;
    }

    private final static int mExportVarIdx_visibleDetailCount = 13;
    private int mExportVar_visibleDetailCount;
    public synchronized void set_visibleDetailCount(int v) {
        setVar(mExportVarIdx_visibleDetailCount, v);
        mExportVar_visibleDetailCount = v;
    }

    public int get_visibleDetailCount() {
        return mExportVar_visibleDetailCount;
    }

    private final static int mExportVarIdx_prefetchCardCount = 14;
    private int mExportVar_prefetchCardCount;
    public synchronized void set_prefetchCardCount(int v) {
        setVar(mExportVarIdx_prefetchCardCount, v);
        mExportVar_prefetchCardCount = v;
    }

    public int get_prefetchCardCount() {
        return mExportVar_prefetchCardCount;
    }

    private final static int mExportVarIdx_detailTextureAlignment = 15;
    private int mExportVar_detailTextureAlignment;
    public synchronized void set_detailTextureAlignment(int v) {
        setVar(mExportVarIdx_detailTextureAlignment, v);
        mExportVar_detailTextureAlignment = v;
    }

    public int get_detailTextureAlignment() {
        return mExportVar_detailTextureAlignment;
    }

    private final static int mExportVarIdx_drawRuler = 16;
    private boolean mExportVar_drawRuler;
    public synchronized void set_drawRuler(boolean v) {
        if (__rs_fp_BOOLEAN!= null) {
            __rs_fp_BOOLEAN.reset();
        } else {
            __rs_fp_BOOLEAN = new FieldPacker(1);
        }
        __rs_fp_BOOLEAN.addBoolean(v);
        setVar(mExportVarIdx_drawRuler, __rs_fp_BOOLEAN);
        mExportVar_drawRuler = v;
    }

    public boolean get_drawRuler() {
        return mExportVar_drawRuler;
    }

    private final static int mExportVarIdx_radius = 17;
    private float mExportVar_radius;
    public synchronized void set_radius(float v) {
        setVar(mExportVarIdx_radius, v);
        mExportVar_radius = v;
    }

    public float get_radius() {
        return mExportVar_radius;
    }

    private final static int mExportVarIdx_cardRotation = 18;
    private float mExportVar_cardRotation;
    public synchronized void set_cardRotation(float v) {
        setVar(mExportVarIdx_cardRotation, v);
        mExportVar_cardRotation = v;
    }

    public float get_cardRotation() {
        return mExportVar_cardRotation;
    }

    private final static int mExportVarIdx_cardsFaceTangent = 19;
    private boolean mExportVar_cardsFaceTangent;
    public synchronized void set_cardsFaceTangent(boolean v) {
        if (__rs_fp_BOOLEAN!= null) {
            __rs_fp_BOOLEAN.reset();
        } else {
            __rs_fp_BOOLEAN = new FieldPacker(1);
        }
        __rs_fp_BOOLEAN.addBoolean(v);
        setVar(mExportVarIdx_cardsFaceTangent, __rs_fp_BOOLEAN);
        mExportVar_cardsFaceTangent = v;
    }

    public boolean get_cardsFaceTangent() {
        return mExportVar_cardsFaceTangent;
    }

    private final static int mExportVarIdx_swaySensitivity = 20;
    private float mExportVar_swaySensitivity;
    public synchronized void set_swaySensitivity(float v) {
        setVar(mExportVarIdx_swaySensitivity, v);
        mExportVar_swaySensitivity = v;
    }

    public float get_swaySensitivity() {
        return mExportVar_swaySensitivity;
    }

    private final static int mExportVarIdx_frictionCoeff = 21;
    private float mExportVar_frictionCoeff;
    public synchronized void set_frictionCoeff(float v) {
        setVar(mExportVarIdx_frictionCoeff, v);
        mExportVar_frictionCoeff = v;
    }

    public float get_frictionCoeff() {
        return mExportVar_frictionCoeff;
    }

    private final static int mExportVarIdx_dragFactor = 22;
    private float mExportVar_dragFactor;
    public synchronized void set_dragFactor(float v) {
        setVar(mExportVarIdx_dragFactor, v);
        mExportVar_dragFactor = v;
    }

    public float get_dragFactor() {
        return mExportVar_dragFactor;
    }

    private final static int mExportVarIdx_fadeInDuration = 23;
    private int mExportVar_fadeInDuration;
    public synchronized void set_fadeInDuration(int v) {
        setVar(mExportVarIdx_fadeInDuration, v);
        mExportVar_fadeInDuration = v;
    }

    public int get_fadeInDuration() {
        return mExportVar_fadeInDuration;
    }

    private final static int mExportVarIdx_cardCreationFadeDuration = 24;
    private int mExportVar_cardCreationFadeDuration;
    public synchronized void set_cardCreationFadeDuration(int v) {
        setVar(mExportVarIdx_cardCreationFadeDuration, v);
        mExportVar_cardCreationFadeDuration = v;
    }

    public int get_cardCreationFadeDuration() {
        return mExportVar_cardCreationFadeDuration;
    }

    private final static int mExportVarIdx_rezInCardCount = 25;
    private float mExportVar_rezInCardCount;
    public synchronized void set_rezInCardCount(float v) {
        setVar(mExportVarIdx_rezInCardCount, v);
        mExportVar_rezInCardCount = v;
    }

    public float get_rezInCardCount() {
        return mExportVar_rezInCardCount;
    }

    private final static int mExportVarIdx_detailFadeRate = 26;
    private float mExportVar_detailFadeRate;
    public synchronized void set_detailFadeRate(float v) {
        setVar(mExportVarIdx_detailFadeRate, v);
        mExportVar_detailFadeRate = v;
    }

    public float get_detailFadeRate() {
        return mExportVar_detailFadeRate;
    }

    private final static int mExportVarIdx_backgroundColor = 27;
    private Float4 mExportVar_backgroundColor;
    public synchronized void set_backgroundColor(Float4 v) {
        mExportVar_backgroundColor = v;
        FieldPacker fp = new FieldPacker(16);
        fp.addF32(v);
        setVar(mExportVarIdx_backgroundColor, fp);
    }

    public Float4 get_backgroundColor() {
        return mExportVar_backgroundColor;
    }

    private final static int mExportVarIdx_rowCount = 28;
    private int mExportVar_rowCount;
    public synchronized void set_rowCount(int v) {
        setVar(mExportVarIdx_rowCount, v);
        mExportVar_rowCount = v;
    }

    public int get_rowCount() {
        return mExportVar_rowCount;
    }

    private final static int mExportVarIdx_rowSpacing = 29;
    private float mExportVar_rowSpacing;
    public synchronized void set_rowSpacing(float v) {
        setVar(mExportVarIdx_rowSpacing, v);
        mExportVar_rowSpacing = v;
    }

    public float get_rowSpacing() {
        return mExportVar_rowSpacing;
    }

    private final static int mExportVarIdx_firstCardTop = 30;
    private boolean mExportVar_firstCardTop;
    public synchronized void set_firstCardTop(boolean v) {
        if (__rs_fp_BOOLEAN!= null) {
            __rs_fp_BOOLEAN.reset();
        } else {
            __rs_fp_BOOLEAN = new FieldPacker(1);
        }
        __rs_fp_BOOLEAN.addBoolean(v);
        setVar(mExportVarIdx_firstCardTop, __rs_fp_BOOLEAN);
        mExportVar_firstCardTop = v;
    }

    public boolean get_firstCardTop() {
        return mExportVar_firstCardTop;
    }

    private final static int mExportVarIdx_dragModel = 31;
    private int mExportVar_dragModel;
    public synchronized void set_dragModel(int v) {
        setVar(mExportVarIdx_dragModel, v);
        mExportVar_dragModel = v;
    }

    public int get_dragModel() {
        return mExportVar_dragModel;
    }

    private final static int mExportVarIdx_fillDirection = 32;
    private int mExportVar_fillDirection;
    public synchronized void set_fillDirection(int v) {
        setVar(mExportVarIdx_fillDirection, v);
        mExportVar_fillDirection = v;
    }

    public int get_fillDirection() {
        return mExportVar_fillDirection;
    }

    private final static int mExportVarIdx_programStoresCard = 33;
    private ScriptField_ProgramStore_s mExportVar_programStoresCard;
    public void bind_programStoresCard(ScriptField_ProgramStore_s v) {
        mExportVar_programStoresCard = v;
        if (v == null) bindAllocation(null, mExportVarIdx_programStoresCard);
        else bindAllocation(v.getAllocation(), mExportVarIdx_programStoresCard);
    }

    public ScriptField_ProgramStore_s get_programStoresCard() {
        return mExportVar_programStoresCard;
    }

    private final static int mExportVarIdx_programStoreBackground = 34;
    private ProgramStore mExportVar_programStoreBackground;
    public synchronized void set_programStoreBackground(ProgramStore v) {
        setVar(mExportVarIdx_programStoreBackground, v);
        mExportVar_programStoreBackground = v;
    }

    public ProgramStore get_programStoreBackground() {
        return mExportVar_programStoreBackground;
    }

    private final static int mExportVarIdx_programStoreDetail = 35;
    private ProgramStore mExportVar_programStoreDetail;
    public synchronized void set_programStoreDetail(ProgramStore v) {
        setVar(mExportVarIdx_programStoreDetail, v);
        mExportVar_programStoreDetail = v;
    }

    public ProgramStore get_programStoreDetail() {
        return mExportVar_programStoreDetail;
    }

    private final static int mExportVarIdx_singleTextureFragmentProgram = 36;
    private ProgramFragment mExportVar_singleTextureFragmentProgram;
    public synchronized void set_singleTextureFragmentProgram(ProgramFragment v) {
        setVar(mExportVarIdx_singleTextureFragmentProgram, v);
        mExportVar_singleTextureFragmentProgram = v;
    }

    public ProgramFragment get_singleTextureFragmentProgram() {
        return mExportVar_singleTextureFragmentProgram;
    }

    private final static int mExportVarIdx_singleTextureBlendingFragmentProgram = 37;
    private ProgramFragment mExportVar_singleTextureBlendingFragmentProgram;
    public synchronized void set_singleTextureBlendingFragmentProgram(ProgramFragment v) {
        setVar(mExportVarIdx_singleTextureBlendingFragmentProgram, v);
        mExportVar_singleTextureBlendingFragmentProgram = v;
    }

    public ProgramFragment get_singleTextureBlendingFragmentProgram() {
        return mExportVar_singleTextureBlendingFragmentProgram;
    }

    private final static int mExportVarIdx_multiTextureFragmentProgram = 38;
    private ProgramFragment mExportVar_multiTextureFragmentProgram;
    public synchronized void set_multiTextureFragmentProgram(ProgramFragment v) {
        setVar(mExportVarIdx_multiTextureFragmentProgram, v);
        mExportVar_multiTextureFragmentProgram = v;
    }

    public ProgramFragment get_multiTextureFragmentProgram() {
        return mExportVar_multiTextureFragmentProgram;
    }

    private final static int mExportVarIdx_multiTextureBlendingFragmentProgram = 39;
    private ProgramFragment mExportVar_multiTextureBlendingFragmentProgram;
    public synchronized void set_multiTextureBlendingFragmentProgram(ProgramFragment v) {
        setVar(mExportVarIdx_multiTextureBlendingFragmentProgram, v);
        mExportVar_multiTextureBlendingFragmentProgram = v;
    }

    public ProgramFragment get_multiTextureBlendingFragmentProgram() {
        return mExportVar_multiTextureBlendingFragmentProgram;
    }

    private final static int mExportVarIdx_vertexProgram = 40;
    private ProgramVertex mExportVar_vertexProgram;
    public synchronized void set_vertexProgram(ProgramVertex v) {
        setVar(mExportVarIdx_vertexProgram, v);
        mExportVar_vertexProgram = v;
    }

    public ProgramVertex get_vertexProgram() {
        return mExportVar_vertexProgram;
    }

    private final static int mExportVarIdx_rasterProgram = 41;
    private ProgramRaster mExportVar_rasterProgram;
    public synchronized void set_rasterProgram(ProgramRaster v) {
        setVar(mExportVarIdx_rasterProgram, v);
        mExportVar_rasterProgram = v;
    }

    public ProgramRaster get_rasterProgram() {
        return mExportVar_rasterProgram;
    }

    private final static int mExportVarIdx_defaultTexture = 42;
    private Allocation mExportVar_defaultTexture;
    public synchronized void set_defaultTexture(Allocation v) {
        setVar(mExportVarIdx_defaultTexture, v);
        mExportVar_defaultTexture = v;
    }

    public Allocation get_defaultTexture() {
        return mExportVar_defaultTexture;
    }

    private final static int mExportVarIdx_loadingTexture = 43;
    private Allocation mExportVar_loadingTexture;
    public synchronized void set_loadingTexture(Allocation v) {
        setVar(mExportVarIdx_loadingTexture, v);
        mExportVar_loadingTexture = v;
    }

    public Allocation get_loadingTexture() {
        return mExportVar_loadingTexture;
    }

    private final static int mExportVarIdx_backgroundTexture = 44;
    private Allocation mExportVar_backgroundTexture;
    public synchronized void set_backgroundTexture(Allocation v) {
        setVar(mExportVarIdx_backgroundTexture, v);
        mExportVar_backgroundTexture = v;
    }

    public Allocation get_backgroundTexture() {
        return mExportVar_backgroundTexture;
    }

    private final static int mExportVarIdx_detailLineTexture = 45;
    private Allocation mExportVar_detailLineTexture;
    public synchronized void set_detailLineTexture(Allocation v) {
        setVar(mExportVarIdx_detailLineTexture, v);
        mExportVar_detailLineTexture = v;
    }

    public Allocation get_detailLineTexture() {
        return mExportVar_detailLineTexture;
    }

    private final static int mExportVarIdx_detailLoadingTexture = 46;
    private Allocation mExportVar_detailLoadingTexture;
    public synchronized void set_detailLoadingTexture(Allocation v) {
        setVar(mExportVarIdx_detailLoadingTexture, v);
        mExportVar_detailLoadingTexture = v;
    }

    public Allocation get_detailLoadingTexture() {
        return mExportVar_detailLoadingTexture;
    }

    private final static int mExportVarIdx_defaultGeometry = 47;
    private Mesh mExportVar_defaultGeometry;
    public synchronized void set_defaultGeometry(Mesh v) {
        setVar(mExportVarIdx_defaultGeometry, v);
        mExportVar_defaultGeometry = v;
    }

    public Mesh get_defaultGeometry() {
        return mExportVar_defaultGeometry;
    }

    private final static int mExportVarIdx_loadingGeometry = 48;
    private Mesh mExportVar_loadingGeometry;
    public synchronized void set_loadingGeometry(Mesh v) {
        setVar(mExportVarIdx_loadingGeometry, v);
        mExportVar_loadingGeometry = v;
    }

    public Mesh get_loadingGeometry() {
        return mExportVar_loadingGeometry;
    }

    private final static int mExportVarIdx_defaultCardMatrix = 49;
    private Matrix4f mExportVar_defaultCardMatrix;
    public synchronized void set_defaultCardMatrix(Matrix4f v) {
        mExportVar_defaultCardMatrix = v;
        FieldPacker fp = new FieldPacker(64);
        fp.addMatrix(v);
        setVar(mExportVarIdx_defaultCardMatrix, fp);
    }

    public Matrix4f get_defaultCardMatrix() {
        return mExportVar_defaultCardMatrix;
    }

    private final static int mExportVarIdx_projectionMatrix = 50;
    private Matrix4f mExportVar_projectionMatrix;
    public synchronized void set_projectionMatrix(Matrix4f v) {
        mExportVar_projectionMatrix = v;
        FieldPacker fp = new FieldPacker(64);
        fp.addMatrix(v);
        setVar(mExportVarIdx_projectionMatrix, fp);
    }

    public Matrix4f get_projectionMatrix() {
        return mExportVar_projectionMatrix;
    }

    private final static int mExportVarIdx_modelviewMatrix = 51;
    private Matrix4f mExportVar_modelviewMatrix;
    public synchronized void set_modelviewMatrix(Matrix4f v) {
        mExportVar_modelviewMatrix = v;
        FieldPacker fp = new FieldPacker(64);
        fp.addMatrix(v);
        setVar(mExportVarIdx_modelviewMatrix, fp);
    }

    public Matrix4f get_modelviewMatrix() {
        return mExportVar_modelviewMatrix;
    }

    private final static int mExportVarIdx_shaderConstants = 52;
    private ScriptField_FragmentShaderConstants_s mExportVar_shaderConstants;
    public void bind_shaderConstants(ScriptField_FragmentShaderConstants_s v) {
        mExportVar_shaderConstants = v;
        if (v == null) bindAllocation(null, mExportVarIdx_shaderConstants);
        else bindAllocation(v.getAllocation(), mExportVarIdx_shaderConstants);
    }

    public ScriptField_FragmentShaderConstants_s get_shaderConstants() {
        return mExportVar_shaderConstants;
    }

    private final static int mExportVarIdx_linearClamp = 53;
    private Sampler mExportVar_linearClamp;
    public synchronized void set_linearClamp(Sampler v) {
        setVar(mExportVarIdx_linearClamp, v);
        mExportVar_linearClamp = v;
    }

    public Sampler get_linearClamp() {
        return mExportVar_linearClamp;
    }

    private final static int mExportFuncIdx_setRadius = 0;
    public void invoke_setRadius(float rad) {
        FieldPacker setRadius_fp = new FieldPacker(4);
        setRadius_fp.addF32(rad);
        invoke(mExportFuncIdx_setRadius, setRadius_fp);
    }

    private final static int mExportFuncIdx_createCards = 1;
    public void invoke_createCards(int start, int total) {
        FieldPacker createCards_fp = new FieldPacker(8);
        createCards_fp.addI32(start);
        createCards_fp.addI32(total);
        invoke(mExportFuncIdx_createCards, createCards_fp);
    }

    private final static int mExportFuncIdx_lookAt = 2;
    public void invoke_lookAt(float fromX, float fromY, float fromZ, float atX, float atY, float atZ, float upX, float upY, float upZ) {
        FieldPacker lookAt_fp = new FieldPacker(36);
        lookAt_fp.addF32(fromX);
        lookAt_fp.addF32(fromY);
        lookAt_fp.addF32(fromZ);
        lookAt_fp.addF32(atX);
        lookAt_fp.addF32(atY);
        lookAt_fp.addF32(atZ);
        lookAt_fp.addF32(upX);
        lookAt_fp.addF32(upY);
        lookAt_fp.addF32(upZ);
        invoke(mExportFuncIdx_lookAt, lookAt_fp);
    }

    private final static int mExportFuncIdx_setTexture = 3;
    public void invoke_setTexture(int n, Allocation texture) {
        FieldPacker setTexture_fp = new FieldPacker(8);
        setTexture_fp.addI32(n);
        setTexture_fp.addObj(texture);
        invoke(mExportFuncIdx_setTexture, setTexture_fp);
    }

    private final static int mExportFuncIdx_setDetailTexture = 4;
    public void invoke_setDetailTexture(int n, float offx, float offy, float loffx, float loffy, Allocation texture) {
        FieldPacker setDetailTexture_fp = new FieldPacker(24);
        setDetailTexture_fp.addI32(n);
        setDetailTexture_fp.addF32(offx);
        setDetailTexture_fp.addF32(offy);
        setDetailTexture_fp.addF32(loffx);
        setDetailTexture_fp.addF32(loffy);
        setDetailTexture_fp.addObj(texture);
        invoke(mExportFuncIdx_setDetailTexture, setDetailTexture_fp);
    }

    private final static int mExportFuncIdx_invalidateTexture = 5;
    public void invoke_invalidateTexture(int n, boolean eraseCurrent) {
        FieldPacker invalidateTexture_fp = new FieldPacker(8);
        invalidateTexture_fp.addI32(n);
        invalidateTexture_fp.addBoolean(eraseCurrent);
        invalidateTexture_fp.skip(3);
        invoke(mExportFuncIdx_invalidateTexture, invalidateTexture_fp);
    }

    private final static int mExportFuncIdx_invalidateDetailTexture = 6;
    public void invoke_invalidateDetailTexture(int n, boolean eraseCurrent) {
        FieldPacker invalidateDetailTexture_fp = new FieldPacker(8);
        invalidateDetailTexture_fp.addI32(n);
        invalidateDetailTexture_fp.addBoolean(eraseCurrent);
        invalidateDetailTexture_fp.skip(3);
        invoke(mExportFuncIdx_invalidateDetailTexture, invalidateDetailTexture_fp);
    }

    private final static int mExportFuncIdx_setGeometry = 7;
    public void invoke_setGeometry(int n, Mesh geometry) {
        FieldPacker setGeometry_fp = new FieldPacker(8);
        setGeometry_fp.addI32(n);
        setGeometry_fp.addObj(geometry);
        invoke(mExportFuncIdx_setGeometry, setGeometry_fp);
    }

    private final static int mExportFuncIdx_setMatrix = 8;
    public void invoke_setMatrix(int n, Matrix4f matrix) {
        FieldPacker setMatrix_fp = new FieldPacker(68);
        setMatrix_fp.addI32(n);
        setMatrix_fp.addMatrix(matrix);
        invoke(mExportFuncIdx_setMatrix, setMatrix_fp);
    }

    private final static int mExportFuncIdx_setProgramStoresCard = 9;
    public void invoke_setProgramStoresCard(int n, ProgramStore programStore) {
        FieldPacker setProgramStoresCard_fp = new FieldPacker(8);
        setProgramStoresCard_fp.addI32(n);
        setProgramStoresCard_fp.addObj(programStore);
        invoke(mExportFuncIdx_setProgramStoresCard, setProgramStoresCard_fp);
    }

    private final static int mExportFuncIdx_setCarouselRotationAngle = 10;
    public void invoke_setCarouselRotationAngle(float carouselRotationAngle) {
        FieldPacker setCarouselRotationAngle_fp = new FieldPacker(4);
        setCarouselRotationAngle_fp.addF32(carouselRotationAngle);
        invoke(mExportFuncIdx_setCarouselRotationAngle, setCarouselRotationAngle_fp);
    }

    private final static int mExportFuncIdx_doStart = 11;
    public void invoke_doStart(float x, float y, long eventTime) {
        FieldPacker doStart_fp = new FieldPacker(16);
        doStart_fp.addF32(x);
        doStart_fp.addF32(y);
        doStart_fp.addI64(eventTime);
        invoke(mExportFuncIdx_doStart, doStart_fp);
    }

    private final static int mExportFuncIdx_doStop = 12;
    public void invoke_doStop(float x, float y, long eventTime) {
        FieldPacker doStop_fp = new FieldPacker(16);
        doStop_fp.addF32(x);
        doStop_fp.addF32(y);
        doStop_fp.addI64(eventTime);
        invoke(mExportFuncIdx_doStop, doStop_fp);
    }

    private final static int mExportFuncIdx_doLongPress = 13;
    public void invoke_doLongPress() {
        invoke(mExportFuncIdx_doLongPress);
    }

    private final static int mExportFuncIdx_doMotion = 14;
    public void invoke_doMotion(float x, float y, long eventTime) {
        FieldPacker doMotion_fp = new FieldPacker(16);
        doMotion_fp.addF32(x);
        doMotion_fp.addF32(y);
        doMotion_fp.addI64(eventTime);
        invoke(mExportFuncIdx_doMotion, doMotion_fp);
    }

    private final static int mExportFuncIdx_setCarouselRotationAngle2 = 15;
    public void invoke_setCarouselRotationAngle2(float endAngle, int milliseconds, int interpolationMode, float maxAnimatedArc) {
        FieldPacker setCarouselRotationAngle2_fp = new FieldPacker(16);
        setCarouselRotationAngle2_fp.addF32(endAngle);
        setCarouselRotationAngle2_fp.addI32(milliseconds);
        setCarouselRotationAngle2_fp.addI32(interpolationMode);
        setCarouselRotationAngle2_fp.addF32(maxAnimatedArc);
        invoke(mExportFuncIdx_setCarouselRotationAngle2, setCarouselRotationAngle2_fp);
    }

}

