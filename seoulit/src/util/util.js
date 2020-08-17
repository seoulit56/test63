
import axios from 'axios';

export default {
  // 정규표현식 영어
  regEng: /^[a-zA-Z]+$/,
  // 정규표현식 한글 
  regKor: /^[가-힣]+$/,
  // 정규표현식 숫자
  regNum: /^[0-9]+$/,
  // 정규표현식 특수문자
  regSpChar: /^[!@#$%^*+=-]+$/,
  // 정규표현식 영어한글
  regEngKor: /^[가-힣a-zA-Z]+$/,
  // 정규표현식 영어숫자
  regEngNum: /^[A-Za-z0-9+]*$/,
  // 메세지 창 오픈
  showAlert: function (vue, type, message) {
    vue.$root.$children[0].showAlert(type, message)
  },
  //메세지 창 클로즈 
  closeAlert: function (vue) {
     vue.$root.$children[0].closeAlert()
  },
  // 컨펌창 오픈
  showConfirm: function (vue, type, message, callback, cancel) {
    vue.$root.$children[0].showConfirm(type, message, callback, cancel)
  },
  // 컨펑창 클로즈
  closeConfirm: function (vue) {
    vue.$root.$children[0].closeConfirm()
  },
  // 빈값 체크
  // 넘어온 값이 빈값인지 체크합니다.
  // !value 하면 생기는 논리적 오류를 제거하기 위해
  // 명시적으로 value == 사용
  // [], {} 도 빈값으로 처리
  isNull: function (value) {
    if( value === '' || value === null || value === undefined || ( value != null && typeof value === "object" && !Object.keys(value).length ) ) {
      return false
    } else {
      return true
    }
  },
  // 중복값 체크
  isDuplicated: function (array, key) {
    const arr = array.map(row => row[key])
    const filter = arr.filter((value, index, arr) => {
      return arr.indexOf(value) !== index
    })
    const duplicate = Array.from(new Set(filter)).join(' / ')
    return duplicate
  },
  // 그리드 상태 변경
  isGridStatus: function(row) {
    if(row.status !== 'add') row.status = 'modify'
  },
  // 정수(float) 변경
  isFloat: function(value) {
    console.log(regInt.test(value))
    if (regInt.test(value)) {
      return parseFloat(value.replace(/[^0-9]/gi,''))
    } else {
      return value.replace(/[^0-9]/gi,'')
    }
     
  },
  dateTime:function (time){
    return new Date(time).toLocaleString()
  },
  getFormatDate:function (date){
    let year = date.getFullYear()
    let month = (1 + date.getMonth())
    month = month >= 10 ? month : '0' + month
    let day = date.getDate()            
    day = day >= 10 ? day : '0' + day         
    return  year + '-' + month + '-' + day       
  },
  minMaxLength:function (value, min, max){
    if(value.length >= min && value.length <= max) return true
    else false
  },  

  // label 셋팅
  setLabel: function (application) {
    const lang = 'ko-kr'
    return axios.get('/api/system/label/app', {params: {application: application, lang: lang}}
    ).then(res => {
      return res.data
    }).catch(error => {
      console.log(error)
    })    
  },

  // 콤보박스 셋팅
  setCombo: function (domain) {
    let $this = domain.obj
    domain.selList.forEach(row => {  
      axios.get('/api/system/domain/detail', {params: {domainId: row.domainId}}
      ).then(res => {
        $this[row.dataObj] = res.data
        if(this.isNull(row.sel) && row.sel === 'A') {
          $this[row.dataObj].unshift({key: '', value: '전체'})
        }
      }).catch(error => {
        console.log(error)
      })    
    })

  }  

}
