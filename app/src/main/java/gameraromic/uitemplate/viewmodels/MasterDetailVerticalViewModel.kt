package gameraromic.uitemplate.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gameraromic.uitemplate.getMembersList
import gameraromic.uitemplate.models.List.GirlGroupMember

class MasterDetailVerticalViewModel : ViewModel() {
    private var currentIndex: Int = 0

    val currentMember: MutableLiveData<GirlGroupMember> = MutableLiveData()
    private val memberList: Array<GirlGroupMember> = getMembersList

    init {
        currentMember.value = memberList[currentIndex]
    }

    fun changeValue() {
        currentIndex += 1
        if (currentIndex == memberList.size) {
            currentIndex = 0
        }
        currentMember.value = memberList[currentIndex]
    }
}