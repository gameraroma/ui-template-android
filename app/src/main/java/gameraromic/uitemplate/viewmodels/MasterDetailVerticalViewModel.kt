package gameraromic.uitemplate.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gameraromic.uitemplate.getMembersList
import gameraromic.uitemplate.models.List.GirlGroupMember

class MasterDetailVerticalViewModel : ViewModel() {
    val currentMember: MutableLiveData<GirlGroupMember> = MutableLiveData()
    private val memberList: Array<GirlGroupMember> = getMembersList

    init {
        currentMember.value = memberList[0]
    }

    fun setCurrentMember(member: GirlGroupMember) {
        currentMember.value = member
    }
}