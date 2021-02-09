//import ModalBox from "./ModalBox.js";

class CSS{
    static set(element, styles){

        for(let key in styles)
            element.style[key] = styles[key];
    }
}

function parse(str) {
    var y = str.substr(0, 4);
    var m = str.substr(5, 2);
    var d = str.substr(8, 2);
	var h = str.substr(11,2);
	var min = str.substr(14,2);
	var s = str.substr(17,2);
    return new Date(y,m-1,d,h,min,s);
}
function getFormatDate(korDate){
	//var korDate = parse(date);
    var year = korDate.getFullYear();              //yyyy
    var month = (1 + korDate.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = korDate.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

function getFormatTime(korDate){
	//var korDate = parse(date);
    var hour = korDate.getHours();              //yyyy
	hour = hour >= 10 ? hour : '0' + hour;
    var minute = korDate.getMinutes();          //M
    minute = minute >= 10 ? minute : '0' + minute;  //month 두자리로 저장
    var second = korDate.getSeconds();                   //d
    second = second >= 10 ? second : '0' + second;          //day 두자리로 저장
    return  hour + ':' + minute + ':' + second;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

class ModalBox{
  
    static alert(date){
        
        
        return new Promise(resolve=>{
            
            let screen = document.createElement("div");
            let frame = document.createElement("div");
            // 차트, 탐색기, 드래그 업로드 박스, 모달박스, 편집기, ...
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"opacity 1s",
				zIndex:"9"
            });
            document.body.append(screen);

            setTimeout(()=>{
                CSS.set(screen,{
                    opacity:"0.5"
                })
            });

            screen.addEventListener("transitionend", ()=>{
                CSS.set(frame, {
                    opacity:"1",
                    top:"50%"
                });
            });

            
            CSS.set(frame, {
                position:"fixed",
                top: "50%",
                left:"50%",
				transform: "translate(-50%,-50%)",
                background: "#fff",
                width:"500px",
                minHeight: "150px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 1s",
				zIndex:"10"
            });
            
            frame.innerHTML = `
            <div style="margin: 20px; width:460px; color:#F65875; font-size: 20px; font-weight:bold; border-bottom:1px solid #F65875;">
            일정등록
            </div>
            <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
            <div class="schedule">
				시작 : <input name="startDate" type="date" value="${date}"/> <input name="startTime" type="time"/><br>
				종료 : <input name="endDate" type="date" value="${date}"/> <input name="endTime" type="time"/><br>
				장소 : <input style="width:230px;" name="location" type="text" placeholder="장소" /><br>
				제목 : <input style="width:230px;" name="title" type="text" placeholder="일정내용" /><br>
				상세내용<br><textarea style="width:263px; height:300px;" name="content"></textarea>
				
			</div>
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input style="margin:10px; width:50px; background-color:#F65875; color:white; border:none;" type="button" value="OK">
            <input style="margin:10px; width:50px; background-color:#F65875; color:white; border:none;" type="button" value="CANCEL">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
			const startDate = frame.querySelector("input[name=startDate]");
			const startTime = frame.querySelector("input[name=startTime]");
			const endDate = frame.querySelector("input[name=endDate]");
			const endTime = frame.querySelector("input[name=endTime]");
			const title = frame.querySelector("input[name=title]");
			const content = frame.querySelector("textarea[name=content]");
			const location = frame.querySelector("input[name=location]");
            okButton.onclick = ()=>{
				let schedule = {
					start:startDate.value+"T"+startTime.value,
					end:endDate.value+"T"+endTime.value,
					title:title.value,
					content:content.value,
					location:location.value
				}
                resolve(schedule);
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                screen.remove();
                frame.remove();
            };

        });
    }
    static confirm(){
        
    }    
}

class DetailBox{
  
    static detail(event){
        
        return new Promise((resolve,reject)=>{
            
            let screen = document.createElement("div");
            let frame = document.createElement("div");
            // 차트, 탐색기, 드래그 업로드 박스, 모달박스, 편집기, ...
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"opacity 1s",
				zIndex:"9"
            });
            document.body.append(screen);

            setTimeout(()=>{
                CSS.set(screen,{
                    opacity:"0.5"
                })
            });

            screen.addEventListener("transitionend", ()=>{
                CSS.set(frame, {
                    opacity:"1",
                    top:"50%"
                });
            });

            
            CSS.set(frame, {
                position:"fixed",
                top: "50%",
                left:"50%",
				transform: "translate(-50%,-50%)",
                background: "#fff",
                width:"500px",
                minHeight: "150px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 1s",
				zIndex:"10"
            });
            
            frame.innerHTML = `
            <div style="margin: 20px; width:460px; color:#F65875; font-size: 20px; font-weight:bold; border-bottom:1px solid #F65875;">
            일정
            </div>
            <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
            <div class="schedule">
				시작 : <input name="startDate" type="date" value="${getFormatDate(event.start)}"/> <input name="startTime" type="time" value="${getFormatTime(event.start)}"/><br>
				종료 : <input name="endDate" type="date" value="${getFormatDate(event.end)}"/> <input name="endTime" type="time" value="${getFormatTime(event.end)}"/><br>
				장소 : <input style="width:230px;" name="location" type="text" value="${event.extendedProps.location}" /><br>
				제목 : <input style="width:230px;" name="title" type="text" value="${event.title}" /><br>
				상세내용<br><textarea style="width:263px; height:300px;" name="content">${event.extendedProps.content}</textarea>
				<input type="hidden" value="${event.id}"/>
				
			</div>
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input style="margin:10px; width:50px; background-color:#F65875; color:white; border:none;" type="button" value="저장">
			<input style="margin:10px; width:50px; background-color:#F65875; color:white; border:none;" type="button" value="삭제">
            <input style="margin:10px; width:50px; background-color:#F65875; color:white; border:none;" type="button" value="취소">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=저장]");
            const cancelButton = frame.querySelector("input[value=취소]");
			const delButton = frame.querySelector("input[value=삭제]");
			const startDate = frame.querySelector("input[name=startDate]");
			const startTime = frame.querySelector("input[name=startTime]");
			const endDate = frame.querySelector("input[name=endDate]");
			const endTime = frame.querySelector("input[name=endTime]");
			const title = frame.querySelector("input[name=title]");
			const content = frame.querySelector("textarea[name=content]");
			const location = frame.querySelector("input[name=location]");
			const eventId = frame.querySelector("input[type=hidden]");
            okButton.onclick = ()=>{
				let schedule = {
					start:startDate.value+"T"+startTime.value,
					end:endDate.value+"T"+endTime.value,
					title:title.value,
					content:content.value,
					location:location.value,
					id:eventId.value
				}
                resolve(schedule);
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                screen.remove();
                frame.remove();
            };
			delButton.onclick = ()=>{
				if(confirm("삭제하시겠습니까?") == true){
					let eventId = event.id;
					reject(eventId);
					screen.remove();
	                frame.remove();
				}
				else{
					return;
				}
			}

        });
    }
    static confirm(){
        
    }    
}

  document.addEventListener('DOMContentLoaded', function() {
	
	let eventList;
	let id = document.querySelector(".id").value;
	
	fetch("/user/calendar/"+id)
		.then(response=>{
			return response.json();
		})
		.then(list=>{
			eventList = list;
			console.log(eventList[0]);
			for(var e of eventList){
				console.log(e);
				srcCalendar.addEvent(e);
			}
		});
	
	
    var srcCalendarEl = document.getElementById('source-calendar');

    var srcCalendar = new FullCalendar.Calendar(srcCalendarEl, {
      plugins: [ 'interaction', 'dayGrid' ],
      editable: true,
      defaultDate: new Date(),
      events: [
      ],
      eventLeave: function(info) { 
        console.log('event left!', info.event);
      }
    });

    srcCalendar.render();
	
	
	const dayGrid = document.querySelector(".fc-day-grid");
	
	

	dayGrid.addEventListener("click",(e)=>{
		console.log(e.target.classList);
		if(!e.target.classList.contains("fc-content") && 
		!e.target.classList.contains("fc-time") &&
		!e.target.classList.contains("fc-title") ){
			
			let clickedDate;
			if(e.target.classList.contains("fc-day-number"))
				clickedDate = e.target.parentNode.getAttribute("data-date");
			else
				clickedDate = e.target.getAttribute("data-date");
				
			ModalBox.alert(clickedDate).then(schedule=>{
				const init = {
				  method: "POST",
					body: JSON.stringify(schedule),
					headers: {
				    "Content-Type": "application/json"
				  },
					credentials : "same-origin"
				}

				fetch("/user/calendar/"+id+"/reg",init)
				.then(result=>result.json())
				.then(result=>{
					console.log(result);
					srcCalendar.addEvent({
			          title: schedule.title,
			          start: schedule.start,
					  content: schedule.content,
			          end: schedule.end,
					  location:schedule.location,
					  id:result
			        });
				});
			});
		}
		else if(e.target.classList.contains("fc-content")){
			console.log(srcCalendar.getEvents());
			for(var event of srcCalendar.getEvents()){
				if(event.id == e.target.querySelector("input[type=hidden]").value){
					DetailBox.detail(event)
					.then(schedule=>{
						const init = {
						  method: "POST",
							body: JSON.stringify(schedule),
							headers: {
						    "Content-Type": "application/json"
						  },
							credentials : "same-origin"
						}
						fetch("/user/calendar/"+schedule.id+"/update",init)
						.then(()=>{});
						
						var delEvent = srcCalendar.getEventById(event.id);
						delEvent.remove();
						srcCalendar.addEvent(schedule);
						
					})
					.catch(eventId=>{
						fetch("/user/calendar/"+eventId+"/delete")
						.then(()=>{});
						
						var delEvent = srcCalendar.getEventById(event.id);
						delEvent.remove();
					});
        			console.log(event.id);
					
				}
			}
		}
		else if(!e.target.classList.contains("fc-content")){
			console.log(srcCalendar.getEvents());
			for(var event of srcCalendar.getEvents()){
				if(event.id == e.target.parentNode.querySelector("input[type=hidden]").value){
					DetailBox.detail(event)
					.then(schedule=>{
						const init = {
						  method: "POST",
							body: JSON.stringify(schedule),
							headers: {
						    "Content-Type": "application/json"
						  },
							credentials : "same-origin"
						}
						fetch("/user/calendar/"+schedule.id+"/update",init)
						.then(()=>{});
						
						var delEvent = srcCalendar.getEventById(event.id);
						delEvent.remove();
						srcCalendar.addEvent(schedule);
					})
					.catch(eventId=>{
						fetch("/user/calendar/"+eventId+"/delete")
						.then(()=>{});
						
						var delEvent = srcCalendar.getEventById(event.id);
						delEvent.remove();
					});
					
        			console.log(event.id);
				}
			}
		}
	});
	

  });