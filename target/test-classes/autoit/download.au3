#include <file.au3>


_Log("----new session----")

if $CmdLine[0] <> 3 then
 ;msgbox(0,"Error","Supply all the Arguments, Browser name and path to upload")
 _Log("Arguments are wrong")
 Exit
EndIf

;Activate firefox
If (StringCompare($CmdLine[1],"firefox",0) = 0) Then
     _Log("FireFox Download starting...")
     _FFDownload()
Else
	_Log("EXITING")
    Exit
 EndIf

Func _FFDownload()
    ; If firefox is set the save the file on some specif location without asking to user.
        ; It will be save after this point.
        ;If not A new Dialog will appear prompting for Path to save
        _Log("Download Window activated")
        ;To change the focus on save button
        Send("{TAB}")
        Sleep(400)
        Send("{TAB}")
        _Log("Change Focus to Save Button")
        ;This is use for if dialoguebox have save and openwith option
        Send("!s")
        ;Click on Enter to Save
        Sleep(400)
        Send("{ENTER}")
        _Log("Press Enter")
        Sleep(400)

     If(WinExists(WinGetTitle("[active]"))) Then
            WinActivate("Enter name of file to save to…")
            $title = WinGetTitle("[active]")
            if($title=="Enter name of file to save to…")Then
				_Log("Active Window Title Is: "&WinGetTitle("[active]") )
				_Log("Enter Name Window Opened And Tiltle is: "&$title)
				ControlSetText($title,"","ComboBox1", " ")

				Sleep(400)
				ControlSetText($title,"","ComboBox1", $CmdLine[2])
				Sleep(400)
				; Save File
				_Log("CommandLine Parameter Found For FilePath and Value is: "& $CmdLine[2])
				;Send("!s")
			    Sleep(400)
			   Send("{TAB}")
				Sleep(400)
			   Send("{TAB}")
				;Send("!s")
				Sleep(400)
				Send("{TAB}")
				Sleep(400)
				Send("{ENTER}")
				;Send("!y")
				_Log("Done")
            EndIf
        EndIf

   ; EndIf
EndFunc


;used for logging
Func _Log($sLogMsg)
_FileWriteLog(@ScriptDir & "\AutoItLog.log",$sLogMsg)
EndFunc