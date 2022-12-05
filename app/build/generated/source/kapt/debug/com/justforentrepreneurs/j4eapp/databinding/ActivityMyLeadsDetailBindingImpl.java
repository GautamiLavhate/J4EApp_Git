package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyLeadsDetailBindingImpl extends ActivityMyLeadsDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(54);
        sIncludes.setIncludes(0, 
            new String[] {"lay_toolbar_my_leads"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_my_leads});
        sIncludes.setIncludes(1, 
            new String[] {"ab_leadsdeatils"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_leadsdeatils});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.leaddeatis, 4);
        sViewsWithIds.put(R.id.imagereqiurment, 5);
        sViewsWithIds.put(R.id.companyName, 6);
        sViewsWithIds.put(R.id.address, 7);
        sViewsWithIds.put(R.id.date, 8);
        sViewsWithIds.put(R.id.title, 9);
        sViewsWithIds.put(R.id.description, 10);
        sViewsWithIds.put(R.id.lead_post_by, 11);
        sViewsWithIds.put(R.id.llProfileInfo, 12);
        sViewsWithIds.put(R.id.ivProfileImg, 13);
        sViewsWithIds.put(R.id.fullname, 14);
        sViewsWithIds.put(R.id.companyName1, 15);
        sViewsWithIds.put(R.id.address1, 16);
        sViewsWithIds.put(R.id.moreIV, 17);
        sViewsWithIds.put(R.id.msg, 18);
        sViewsWithIds.put(R.id.tvRecommended, 19);
        sViewsWithIds.put(R.id.tvRecommendedMySelf, 20);
        sViewsWithIds.put(R.id.llRecommendedSection, 21);
        sViewsWithIds.put(R.id.recommended_personlist, 22);
        sViewsWithIds.put(R.id.reffrerdetails, 23);
        sViewsWithIds.put(R.id.requirementtitle, 24);
        sViewsWithIds.put(R.id.reffraldate, 25);
        sViewsWithIds.put(R.id.satatus, 26);
        sViewsWithIds.put(R.id.reffraldescription, 27);
        sViewsWithIds.put(R.id.referralTypeOutside, 28);
        sViewsWithIds.put(R.id.contactname, 29);
        sViewsWithIds.put(R.id.condignation, 30);
        sViewsWithIds.put(R.id.mobilenumber, 31);
        sViewsWithIds.put(R.id.telphno, 32);
        sViewsWithIds.put(R.id.emailadd, 33);
        sViewsWithIds.put(R.id.insidecontact, 34);
        sViewsWithIds.put(R.id.conProfileInfo, 35);
        sViewsWithIds.put(R.id.conProfileImg, 36);
        sViewsWithIds.put(R.id.confullname, 37);
        sViewsWithIds.put(R.id.confunarea, 38);
        sViewsWithIds.put(R.id.conmoreIV, 39);
        sViewsWithIds.put(R.id.sattuslist, 40);
        sViewsWithIds.put(R.id.referralReceivedBy, 41);
        sViewsWithIds.put(R.id.llProfileInfoReceivedBy, 42);
        sViewsWithIds.put(R.id.ivProfileImgReceivedBy, 43);
        sViewsWithIds.put(R.id.fullnameReceivedBy, 44);
        sViewsWithIds.put(R.id.funReceivedBy, 45);
        sViewsWithIds.put(R.id.moreIVReceivedBy, 46);
        sViewsWithIds.put(R.id.reffralfuctionarea, 47);
        sViewsWithIds.put(R.id.referralGivenBy, 48);
        sViewsWithIds.put(R.id.llProfileInfore, 49);
        sViewsWithIds.put(R.id.ivProfileImgre, 50);
        sViewsWithIds.put(R.id.fullnamere, 51);
        sViewsWithIds.put(R.id.funre, 52);
        sViewsWithIds.put(R.id.moreIVre, 53);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsdeatilsBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyLeadsDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 54, sIncludes, sViewsWithIds));
    }
    private ActivityMyLeadsDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[15]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[36]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[35]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[38]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[39]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[52]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[34]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[13]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[43]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[50]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[42]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[49]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.TextView) bindings[31]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[17]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[46]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[53]
            , (android.widget.TextView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (android.widget.LinearLayout) bindings[48]
            , (android.widget.LinearLayout) bindings[41]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[47]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[40]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[9]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarMyLeadsBinding) bindings[2]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[20]
            );
        this.leaddeatis1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsdeatilsBinding) bindings[3];
        setContainedBinding(this.mboundView1);
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
        mboundView1.invalidateAll();
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
        if (mboundView1.hasPendingBindings()) {
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarMyLeadsBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarMyLeadsBinding Toolbar, int fieldId) {
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
        executeBindingsOn(mboundView1);
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