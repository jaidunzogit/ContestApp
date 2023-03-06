package com.learn.contest

import com.learn.contest.retrofitService.RetrofitService
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }

//
//    @Mock
//    lateinit var mainRepository: MainRepository
//
//    @Mock
//    lateinit var retrofitService: RetrofitService
//
//    @Mock
//    lateinit var z:Call<List<AllContest>>
//
//    @Mock
//    lateinit var context: Context
//
//    @Mock
//    lateinit var el:List<AllContest>
//
//    @Before
//    fun setup(){
//        MockitoAnnotations.initMocks(this)
//        Mockito.`when`(mainRepository.getallcontest()).thenReturn(z)
//    }
//
//    @Test
//    fun testviewmodel(){
//        val sut = MainViewModel(mainRepository, context)
//        sut.getAllContest()
//        Assert.assertEquals(sut.allcontest, el)
//    }

    @Test
    fun retrofitservice(){
       assertNotNull(RetrofitService.getInstance())
    }
}