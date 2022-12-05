package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileAboutUsEditBindingImpl extends ActivityProfileAboutUsEditBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(68);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_editbtn"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_editbtn});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llProfileInfo, 3);
        sViewsWithIds.put(R.id.ivProfileImg, 4);
        sViewsWithIds.put(R.id.imageadd, 5);
        sViewsWithIds.put(R.id.fullname, 6);
        sViewsWithIds.put(R.id.companyName, 7);
        sViewsWithIds.put(R.id.address, 8);
        sViewsWithIds.put(R.id.edtAboutCompany, 9);
        sViewsWithIds.put(R.id.edtCompanyName, 10);
        sViewsWithIds.put(R.id.llBusinessEntity, 11);
        sViewsWithIds.put(R.id.tvBusinessEntity, 12);
        sViewsWithIds.put(R.id.ivCrossBusinessEntity, 13);
        sViewsWithIds.put(R.id.ivDropDownBusinessEntity, 14);
        sViewsWithIds.put(R.id.ivDropUpBusinessEntity, 15);
        sViewsWithIds.put(R.id.rvBusinessEntity, 16);
        sViewsWithIds.put(R.id.spBusinessEntity, 17);
        sViewsWithIds.put(R.id.llBusinessType, 18);
        sViewsWithIds.put(R.id.tvBusinessType, 19);
        sViewsWithIds.put(R.id.ivCrossBusinessType, 20);
        sViewsWithIds.put(R.id.ivDropDownBusinessType, 21);
        sViewsWithIds.put(R.id.ivDropUpBusinessType, 22);
        sViewsWithIds.put(R.id.rvBusinessType, 23);
        sViewsWithIds.put(R.id.spBusinessType, 24);
        sViewsWithIds.put(R.id.llBusinessExpertise, 25);
        sViewsWithIds.put(R.id.tvBusinessExpertise, 26);
        sViewsWithIds.put(R.id.ivCrossBusinessExpertise, 27);
        sViewsWithIds.put(R.id.ivDropDownBusinessExpertise, 28);
        sViewsWithIds.put(R.id.ivDropUpBusinessExpertise, 29);
        sViewsWithIds.put(R.id.rvBusinessExpertise, 30);
        sViewsWithIds.put(R.id.spBusinessExpertise, 31);
        sViewsWithIds.put(R.id.edtWorkingFrom, 32);
        sViewsWithIds.put(R.id.llCategorySelection1, 33);
        sViewsWithIds.put(R.id.tvCategory1, 34);
        sViewsWithIds.put(R.id.ivCrossNoOfEmployee, 35);
        sViewsWithIds.put(R.id.ivDropDown1, 36);
        sViewsWithIds.put(R.id.ivDropUp1, 37);
        sViewsWithIds.put(R.id.rvCategory1, 38);
        sViewsWithIds.put(R.id.llCategorySelection, 39);
        sViewsWithIds.put(R.id.tvCategory, 40);
        sViewsWithIds.put(R.id.ivCrossExpectedTurnover, 41);
        sViewsWithIds.put(R.id.ivDropDown, 42);
        sViewsWithIds.put(R.id.ivDropUp, 43);
        sViewsWithIds.put(R.id.rvCategory, 44);
        sViewsWithIds.put(R.id.edtTagetAudience, 45);
        sViewsWithIds.put(R.id.tvFileName, 46);
        sViewsWithIds.put(R.id.ivImgPdf, 47);
        sViewsWithIds.put(R.id.texfilname, 48);
        sViewsWithIds.put(R.id.ivImgAdd, 49);
        sViewsWithIds.put(R.id.relativelayoutPdfAvailable, 50);
        sViewsWithIds.put(R.id.ivImgPdfAvailable, 51);
        sViewsWithIds.put(R.id.ivCancel, 52);
        sViewsWithIds.put(R.id.relativelayoutPdfEdit, 53);
        sViewsWithIds.put(R.id.ivImgPdfAvailableEdit, 54);
        sViewsWithIds.put(R.id.ivPdfEdit, 55);
        sViewsWithIds.put(R.id.ivPdfDelete, 56);
        sViewsWithIds.put(R.id.tvPPTName, 57);
        sViewsWithIds.put(R.id.ivImgPpt, 58);
        sViewsWithIds.put(R.id.ivImgAddPpt, 59);
        sViewsWithIds.put(R.id.relativelayoutPptAvailable, 60);
        sViewsWithIds.put(R.id.ivImgPptAvailable, 61);
        sViewsWithIds.put(R.id.ivCancelPpt, 62);
        sViewsWithIds.put(R.id.relativelayoutPptEdit, 63);
        sViewsWithIds.put(R.id.ivImgPptAvailableEdit, 64);
        sViewsWithIds.put(R.id.ivPptEdit, 65);
        sViewsWithIds.put(R.id.ivPptDelete, 66);
        sViewsWithIds.put(R.id.editabout1, 67);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileAboutUsEditBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 68, sIncludes, sViewsWithIds));
    }
    private ActivityProfileAboutUsEditBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[67]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[45]
            , (android.widget.EditText) bindings[32]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[52]
            , (android.widget.ImageView) bindings[62]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[41]
            , (android.widget.ImageView) bindings[35]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[28]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[43]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[29]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.LinearLayout) bindings[49]
            , (android.widget.LinearLayout) bindings[59]
            , (android.widget.ImageView) bindings[47]
            , (android.widget.ImageView) bindings[51]
            , (android.widget.ImageView) bindings[54]
            , (android.widget.ImageView) bindings[58]
            , (android.widget.ImageView) bindings[61]
            , (android.widget.ImageView) bindings[64]
            , (android.widget.ImageView) bindings[56]
            , (android.widget.ImageView) bindings[55]
            , (android.widget.ImageView) bindings[66]
            , (android.widget.ImageView) bindings[65]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[39]
            , (android.widget.LinearLayout) bindings[33]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.RelativeLayout) bindings[50]
            , (android.widget.RelativeLayout) bindings[53]
            , (android.widget.RelativeLayout) bindings[60]
            , (android.widget.RelativeLayout) bindings[63]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (androidx.recyclerview.widget.RecyclerView) bindings[44]
            , (androidx.recyclerview.widget.RecyclerView) bindings[38]
            , (android.widget.Spinner) bindings[17]
            , (android.widget.Spinner) bindings[31]
            , (android.widget.Spinner) bindings[24]
            , (android.widget.TextView) bindings[48]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[34]
            , (android.widget.RelativeLayout) bindings[46]
            , (android.widget.RelativeLayout) bindings[57]
            );
        this.editabout.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}