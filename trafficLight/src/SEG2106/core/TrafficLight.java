package SEG2106.core;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling
language!*/
public class TrafficLight implements EventHandler
{
//------------------------
// MEMBER VARIABLES
//------------------------
//TrafficLight State Machines
public enum Status { initialTrafficMode, lowTrafficMode, moderateTrafficMode,
highTrafficMode }
public enum StatusLowTrafficMode { Null, northAndSouthGreenArrow,
northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow }
public enum StatusModerateTrafficMode { Null, northGreenAndArrow, northYellow,
southGreenAndArrow, southYellow, westAndEastGreen, westAndEastYellowM }
public enum StatusHighTrafficMode { Null, northGreenAndArrowH, northYellowH,
southGreenAndArrowH, southYellowH, westGreenAndArrowH, westAndEastGreenH,
westAndEastYellowH }
private Status status;
private StatusLowTrafficMode statusLowTrafficMode;
private StatusModerateTrafficMode statusModerateTrafficMode;
private StatusHighTrafficMode statusHighTrafficMode;
//------------------------
// CONSTRUCTOR
//------------------------
private final TrafficLightManager trafficLightManager;
public TrafficLight(TrafficLightManager trafficLightManager){
	setStatusLowTrafficMode(StatusLowTrafficMode.Null);
	setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
	setStatusHighTrafficMode(StatusHighTrafficMode.Null);
	setStatus(Status.initialTrafficMode);
	this.trafficLightManager = trafficLightManager;
	trafficLightManager.addEventHandler(this);
	}
//------------------------
// INTERFACE
//------------------------
public String getStatusFullName(){
	String answer = status.toString();
	if (statusLowTrafficMode != StatusLowTrafficMode.Null) { answer += "." +statusLowTrafficMode.toString(); }
	if (statusModerateTrafficMode != StatusModerateTrafficMode.Null) { answer += "."+ statusModerateTrafficMode.toString(); }
	if (statusHighTrafficMode != StatusHighTrafficMode.Null) { answer += "." +statusHighTrafficMode.toString(); }
	return answer;
	}
public Status getStatus(){
	return status;
	}
public StatusLowTrafficMode getStatusLowTrafficMode(){
	return statusLowTrafficMode;
	}
public StatusModerateTrafficMode getStatusModerateTrafficMode(){
	return statusModerateTrafficMode;
	}
public StatusHighTrafficMode getStatusHighTrafficMode(){
	return statusHighTrafficMode;
	}
public boolean lowTraffic(){
	boolean wasEventProcessed = false;
	Status aStatus = status;
	switch (aStatus)
	{
	case initialTrafficMode:
		setStatus(Status.lowTrafficMode);
		wasEventProcessed = true;
		break;
	default:
		// Other states do respond to this event
	}	
	return wasEventProcessed;
	}
public boolean moderateTraffic(){
	boolean wasEventProcessed = false;
	Status aStatus = status;
	switch (aStatus)
	{
	case initialTrafficMode:
		setStatus(Status.moderateTrafficMode);
		wasEventProcessed = true;
		break;
	default:
		// Other states do respond to this event
	}
	return wasEventProcessed;
	}
public boolean highTraffic(){
	boolean wasEventProcessed = false;
	Status aStatus = status;
	switch (aStatus)
	{
	case initialTrafficMode:
		setStatus(Status.highTrafficMode);
		wasEventProcessed = true;
		break;
	default:
		// Other states do respond to this event
	}
	return wasEventProcessed;
	}
public boolean timerGreen()
{
boolean wasEventProcessed = false;
StatusLowTrafficMode aStatusLowTrafficMode = statusLowTrafficMode;
StatusModerateTrafficMode aStatusModerateTrafficMode =
statusModerateTrafficMode;
StatusHighTrafficMode aStatusHighTrafficMode = statusHighTrafficMode;
switch (aStatusLowTrafficMode)
{
case northAndSouthGreenArrow:
exitStatusLowTrafficMode();
setStatusLowTrafficMode(StatusLowTrafficMode.northAndSouthGreen);
wasEventProcessed = true;
break;
case northAndSouthGreen:
exitStatusLowTrafficMode();
setStatusLowTrafficMode(StatusLowTrafficMode.northAndSouthYellow);
wasEventProcessed = true;
break;
case northAndSouthRed:
exitStatusLowTrafficMode();
setStatusLowTrafficMode(StatusLowTrafficMode.westAndEastYellow);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
switch (aStatusModerateTrafficMode)
{
case northGreenAndArrow:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.northYellow);
wasEventProcessed = true;
break;
case southGreenAndArrow:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.southYellow);
wasEventProcessed = true;
break;
case westAndEastGreen:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.westAndEastYellowM);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
switch (aStatusHighTrafficMode)
{
case northGreenAndArrowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.northYellowH);
wasEventProcessed = true;
break;
case southGreenAndArrowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.southYellowH);
wasEventProcessed = true;
break;
case westGreenAndArrowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.westAndEastGreenH);
wasEventProcessed = true;
break;
case westAndEastGreenH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.westAndEastYellowH);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
return wasEventProcessed;
}
public boolean timerYellow()
{
boolean wasEventProcessed = false;
StatusLowTrafficMode aStatusLowTrafficMode = statusLowTrafficMode;
StatusModerateTrafficMode aStatusModerateTrafficMode =
statusModerateTrafficMode;
StatusHighTrafficMode aStatusHighTrafficMode = statusHighTrafficMode;
switch (aStatusLowTrafficMode)
{
case northAndSouthYellow:
exitStatusLowTrafficMode();
setStatusLowTrafficMode(StatusLowTrafficMode.northAndSouthRed);
wasEventProcessed = true;
break;
case westAndEastYellow:
exitStatusLowTrafficMode();
setStatusLowTrafficMode(StatusLowTrafficMode.northAndSouthGreenArrow);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
switch (aStatusModerateTrafficMode)
{
case northYellow:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.southGreenAndArrow);
wasEventProcessed = true;
break;
case southYellow:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.westAndEastGreen);
wasEventProcessed = true;
break;
case westAndEastYellowM:
exitStatusModerateTrafficMode();
setStatusModerateTrafficMode(StatusModerateTrafficMode.northGreenAndArrow);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
switch (aStatusHighTrafficMode)
{
case northYellowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.southGreenAndArrowH);
wasEventProcessed = true;
break;
case southYellowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.westGreenAndArrowH);
wasEventProcessed = true;
break;
case westAndEastYellowH:
exitStatusHighTrafficMode();
setStatusHighTrafficMode(StatusHighTrafficMode.northGreenAndArrowH);
wasEventProcessed = true;
break;
default:
// Other states do respond to this event
}
return wasEventProcessed;
}
private void exitStatus()
{
switch(status)
{
case lowTrafficMode:
exitStatusLowTrafficMode();
break;
case moderateTrafficMode:
exitStatusModerateTrafficMode();
break;
case highTrafficMode:
exitStatusHighTrafficMode();
break;
}
}
private void setStatus(Status aStatus)
{
status = aStatus;
// entry actions and do activities
switch(status)
{
case lowTrafficMode:
if (statusLowTrafficMode == StatusLowTrafficMode.Null) {
setStatusLowTrafficMode(StatusLowTrafficMode.northAndSouthGreenArrow); }
break;
case moderateTrafficMode:
if (statusModerateTrafficMode == StatusModerateTrafficMode.Null) {
setStatusModerateTrafficMode(StatusModerateTrafficMode.northGreenAndArrow); }
break;
case highTrafficMode:
if (statusHighTrafficMode == StatusHighTrafficMode.Null) {
setStatusHighTrafficMode(StatusHighTrafficMode.northGreenAndArrowH); }
break;
}
}
private void exitStatusLowTrafficMode()
{
switch(statusLowTrafficMode)
{
case northAndSouthGreenArrow:
setStatusLowTrafficMode(StatusLowTrafficMode.Null);
break;
case northAndSouthGreen:
setStatusLowTrafficMode(StatusLowTrafficMode.Null);
break;
case northAndSouthYellow:
setStatusLowTrafficMode(StatusLowTrafficMode.Null);
break;
case northAndSouthRed:
setStatusLowTrafficMode(StatusLowTrafficMode.Null);
break;
case westAndEastYellow:
setStatusLowTrafficMode(StatusLowTrafficMode.Null);
break;
}
}
private void setStatusLowTrafficMode(StatusLowTrafficMode aStatusLowTrafficMode)
{
statusLowTrafficMode = aStatusLowTrafficMode;
if (status != Status.lowTrafficMode && aStatusLowTrafficMode !=
StatusLowTrafficMode.Null) { setStatus(Status.lowTrafficMode); }
// entry actions and do activities
switch(statusLowTrafficMode)
{
case northAndSouthGreenArrow:
// line 14 "model.ump"
trafficLightManager.northArrow();
// line 15 "model.ump"
trafficLightManager.southArrow();
// line 16 "model.ump"
trafficLightManager.westRed();
// line 17 "model.ump"
trafficLightManager.eastRed();
break;
case northAndSouthGreen:
// line 21 "model.ump"
trafficLightManager.northGreen();
// line 22 "model.ump"
trafficLightManager.southGreen();
// line 23 "model.ump"
trafficLightManager.westRed();
// line 24 "model.ump"
trafficLightManager.eastRed();
break;
case northAndSouthYellow:
// line 28 "model.ump"
trafficLightManager.northYellow();
// line 29 "model.ump"
trafficLightManager.southYellow();
// line 30 "model.ump"
trafficLightManager.westRed();
// line 31 "model.ump"
trafficLightManager.eastRed();
break;
case northAndSouthRed:
// line 36 "model.ump"
trafficLightManager.northRed();
// line 37 "model.ump"
trafficLightManager.southRed();
// line 38 "model.ump"
trafficLightManager.westGreen();
// line 39 "model.ump"
trafficLightManager.eastGreen();
break;
case westAndEastYellow:
// line 44 "model.ump"
trafficLightManager.northRed();
// line 45 "model.ump"
trafficLightManager.southRed();
// line 46 "model.ump"
trafficLightManager.westYellow();
// line 47 "model.ump"
trafficLightManager.eastYellow();
break;
}
}
private void exitStatusModerateTrafficMode()
{
switch(statusModerateTrafficMode)
{
case northGreenAndArrow:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
case northYellow:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
case southGreenAndArrow:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
case southYellow:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
case westAndEastGreen:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
case westAndEastYellowM:
setStatusModerateTrafficMode(StatusModerateTrafficMode.Null);
break;
}
}
private void setStatusModerateTrafficMode(StatusModerateTrafficMode
aStatusModerateTrafficMode)
{
statusModerateTrafficMode = aStatusModerateTrafficMode;
if (status != Status.moderateTrafficMode && aStatusModerateTrafficMode !=
StatusModerateTrafficMode.Null) { setStatus(Status.moderateTrafficMode); }
// entry actions and do activities
switch(statusModerateTrafficMode)
{
case northGreenAndArrow:
// line 55 "model.ump"
trafficLightManager.northGreenAndArrow();
// line 56 "model.ump"
trafficLightManager.southRed();
// line 57 "model.ump"
trafficLightManager.westRed();
// line 58 "model.ump"
trafficLightManager.eastRed();
break;
case northYellow:
// line 62 "model.ump"
trafficLightManager.northYellow();
// line 63 "model.ump"
trafficLightManager.southRed();
// line 64 "model.ump"
trafficLightManager.westRed();
// line 65 "model.ump"
trafficLightManager.eastRed();
break;
case southGreenAndArrow:
// line 69 "model.ump"
trafficLightManager.northRed();
// line 70 "model.ump"
trafficLightManager.southGreenAndArrow();
// line 71 "model.ump"
trafficLightManager.westRed();
// line 72 "model.ump"
trafficLightManager.eastRed();
break;
case southYellow:
// line 76 "model.ump"
trafficLightManager.northRed();
// line 77 "model.ump"
trafficLightManager.southYellow();
// line 78 "model.ump"
trafficLightManager.westRed();
// line 79 "model.ump"
trafficLightManager.eastRed();
break;
case westAndEastGreen:
// line 83 "model.ump"
trafficLightManager.northRed();
// line 84 "model.ump"
trafficLightManager.southRed();
// line 85 "model.ump"
trafficLightManager.westGreen();
// line 86 "model.ump"
trafficLightManager.eastGreen();
break;
case westAndEastYellowM:
// line 90 "model.ump"
trafficLightManager.northRed();
// line 91 "model.ump"
trafficLightManager.southRed();
// line 92 "model.ump"
trafficLightManager.westYellow();
// line 93 "model.ump"
trafficLightManager.eastYellow();
break;
}
}
private void exitStatusHighTrafficMode()
{
switch(statusHighTrafficMode)
{
case northGreenAndArrowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case northYellowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case southGreenAndArrowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case southYellowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case westGreenAndArrowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case westAndEastGreenH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
case westAndEastYellowH:
setStatusHighTrafficMode(StatusHighTrafficMode.Null);
break;
}
}
private void setStatusHighTrafficMode(StatusHighTrafficMode
aStatusHighTrafficMode)
{
statusHighTrafficMode = aStatusHighTrafficMode;
if (status != Status.highTrafficMode && aStatusHighTrafficMode !=
StatusHighTrafficMode.Null) { setStatus(Status.highTrafficMode); }
// entry actions and do activities
switch(statusHighTrafficMode)
{
case northGreenAndArrowH:
// line 102 "model.ump"
trafficLightManager.northGreenAndArrow();
// line 103 "model.ump"
trafficLightManager.southRed();
// line 104 "model.ump"
trafficLightManager.westRed();
// line 105 "model.ump"
trafficLightManager.eastRed();
break;
case northYellowH:
// line 109 "model.ump"
trafficLightManager.northYellow();
// line 110 "model.ump"
trafficLightManager.southRed();
// line 111 "model.ump"
trafficLightManager.westRed();
// line 112 "model.ump"
trafficLightManager.eastRed();
break;
case southGreenAndArrowH:
// line 116 "model.ump"
trafficLightManager.northRed();
// line 117 "model.ump"
trafficLightManager.southGreenAndArrow();
// line 118 "model.ump"
trafficLightManager.westRed();
// line 119 "model.ump"
trafficLightManager.eastRed();
break;
case southYellowH:
// line 123 "model.ump"
trafficLightManager.northRed();
// line 124 "model.ump"
trafficLightManager.southYellow();
// line 125 "model.ump"
trafficLightManager.westRed();
// line 126 "model.ump"
trafficLightManager.eastRed();
break;
case westGreenAndArrowH:
// line 130 "model.ump"
trafficLightManager.northRed();
// line 131 "model.ump"
trafficLightManager.southRed();
// line 132 "model.ump"
trafficLightManager.westGreenAndArrow();
// line 133 "model.ump"
trafficLightManager.eastRed();
break;
case westAndEastGreenH:
// line 137 "model.ump"
trafficLightManager.northRed();
// line 138 "model.ump"
trafficLightManager.southRed();
// line 139 "model.ump"
trafficLightManager.westGreen();
// line 140 "model.ump"
trafficLightManager.eastGreen();
break;
case westAndEastYellowH:
// line 144 "model.ump"
trafficLightManager.northRed();
// line 145 "model.ump"
trafficLightManager.southRed();
// line 146 "model.ump"
trafficLightManager.westYellow();
// line 147 "model.ump"
trafficLightManager.eastYellow();
break;
}
}
public void delete()
{}
}