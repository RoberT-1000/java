TITLE Mathematics

; Assigns values to variables and then exits

INCLUDE Irvine32.inc

.data

prompt1				BYTE		"Enter first number or 0 to EXIT: ", 0
prompt2				BYTE		"Enter second number: ", 0
prompt3				BYTE		"Enter operation ( + - * / ): ", 0
answerDec			BYTE		"The answer is: ", 0
answerHex			BYTE		"The answer (HEX) is: ", 0
answerRemDec		BYTE		"The remainder is: ", 0
answerRemHex		BYTE		"The remainder (HEX) is: ", 0
exitStr				BYTE		"The program has been terminated. ", 0
errorMessage		BYTE		"Invalid character. You must enter a valid mathematical operator. ", 0
firstInt			SDWORD	?
secondInt			SDWORD	?
addInts				SDWORD	?
subInts				SDWORD	?
mulInts				SDWORD	?
divInts				SDWORD	?
remInts				SDWORD	?


.code
main PROC
		; starting by moving 1 to the loop register to jump into the program
		MOV			ECX, 1		
		ProgLoop:
			; calling the mainMenu procedure...
			CALL		mainMenu
			
			; ========================================================================================
			; >>>> BELOW IS MY NOT-SO-ELEGANT SOLUTION FOR COMPARING THE MATHEMATICAL INSTRUCTION <<<<
			; ========================================================================================

			; comparing the value '+' to the AL register...
			;    to determine if we are going to add
			;    or jump to the 'is this the subtraction instruction'
			;    bit of code...
			CMP			AL, '+'
			JZ			jmpAddNums
			JNZ			jmpIsSub

			jmpAddNums:
				CALL	addNums
				INC		ECX
				LOOP	ProgLoop

			; comparing the value '-' to the AL register...
			;    to determine if we are going to subtract
			;    or jump to the 'is this the multiplication instruction'
			;    bit of code...
			jmpIsSub:
				CMP		AL, '-'
				JZ		jmpSubNums
				JNZ		jmpIsMul

			jmpSubNums:
				CALL	subNums
				INC		ECX
				LOOP	ProgLoop

			; comparing the value '*' to the AL register...
			;    to determine if we are going to subtract
			;    or jump to the 'is this the multiplication instruction'
			;    bit of code...
			jmpIsMul:
				CMP		AL, '*'
				JZ		jmpMulNums
				JNZ		jmpIsDiv

			jmpMulNums:
				CALL	mulNums
				INC		ECX
				LOOP	ProgLoop

			; comparing the value '/' to the AL register...
			;    to determine if we are going to divide
			;    or jump to the 'you need to enter a valid instruction'
			;    bit of code...
			jmpIsDiv:
				CMP		AL, '/'
				JZ		jmpDivNums
				JNZ		jmpError

			jmpDivNums:
				CALL	divNums
				INC		ECX
				LOOP	ProgLoop

			jmpError:
				CALL	invalidInstruction
				INC		ECX
				LOOP	ProgLoop

			; increment and going to the top of the program
			INC  ECX
			LOOP ProgLoop
	EXIT

	; -----------------------------
	; -----------------------------
	; >>>>> CUSTOM PROCEDURES <<<<<
	; -----------------------------
	; -----------------------------


	; -----------------------------------
	mainMenu PROC
	; This procedure creates the main menu text
	;    and accepts input from the user
	; The procedure assigns value to the firstInt and 
	;    secondInt variables.
			CALL		CrLf
			MOV			EDX, OFFSET prompt1
			CALL		WriteString
			CALL		ReadInt	
			JZ			EXIT_PROGRAM		; calling the function that exits the program when the zero flag is set
			MOV			firstInt, EAX
			MOV			EDX, OFFSET prompt2
			CALL		WriteString
			CALL		ReadInt
			MOV			secondInt, EAX
			MOV			EDX, OFFSET prompt3
			CALL		WriteString
			CALL		ReadChar
			CALL		WriteChar
			CALL		CrLf
			RET
	mainMenu ENDP
	; ---------------------------------------


	; ------------------------------------------------
	mulNums PROC
	; this procedure multiplies the two numbers...
	;      writes the answer in decimal and hex...
		MOV		EAX, firstInt
		MOV		EBX, secondInt
		MUL		EBX
		MOV		EDX, OFFSET answerDec
		CALL	WriteString
		CALL	WriteInt
		CALL	CrLf
		MOV		EDX, OFFSET answerHex
		CALL	WriteString
		CALL	WriteHex
		CALL	CrLf
		RET
	mulNums ENDP
	; ------------------------------------------------


	; ----------------------------------------------------
	subNums PROC
	; this function substracts secondInt from firstInt and 
	;      writes the answer in decimal and hex...
		MOV			EAX, firstInt
		SUB			EAX, secondInt
		MOV			EDX, OFFSET answerDec
		CALL		WriteString
		CALL		WriteInt
		CALL		CrLf
		MOV			EDX, OFFSET answerHex
		CALL		WriteString
		CALL		WriteHex
		CALL	CrLf
		RET
	subNums ENDP
	; ----------------------------------------------------


	; ----------------------------------------------------
	addNums PROC
	; this function adds firstInt and secondInt and writes the 
	;      answer in decimal and hex...
		MOV			EAX, firstInt
		ADD			EAX, secondInt
		MOV			EDX, OFFSET answerDec
		CALL		WriteString
		CALL		WriteInt
		CALL		CrLf
		MOV			EDX, OFFSET answerHex
		CALL		WriteString
		CALL		WriteHex
		CALL	CrLf
		RET
	addNums ENDP
	; ----------------------------------------------------


	; ----------------------------------------------------
	divNums PROC
	; this function adds firstInt and secondInt and writes the 
	;      answer in decimal and hex...
		MOV			EDX, OFFSET answerDec
		CALL		WriteString
		MOV			EDX, 0				; zeroing the EDX register
		MOV			EAX, firstInt
		MOV			EBX, secondInt
		DIV			EBX
		MOV			divInts, EBX
		CALL		WriteInt
		CALL		CrLf
		MOV			EDX, OFFSET answerHex
		CALL		WriteString
		CALL		WriteHex
		CALL		CrLf
		; creating the remainder in the least elegant way possible...
		;     multiplying the divisor by the quotient...
		;     and then that answer is subtracted from the dividend
		MUL			EBX		
		MOV			EBX, firstInt	
		SUB			EBX, EAX
		XCHG		EBX, EAX

		MOV			EDX, OFFSET answerRemDec
		CALL		WriteString
		CALL		WriteInt
		CALL		CrLf
		MOV			EDX, OFFSET answerRemHex
		CALL		WriteString
		CALL		WriteHex
		CALL		CrLf
		RET
	divNums ENDP
	; ----------------------------------------------------
	

	; ----------------------------------------------------
	EXIT_PROGRAM PROC
	; the procedure that is called when the zero flag is set
		MOV		EDX, OFFSET exitStr
		CALL	CrLf
		CALL	WriteString
		CALL	CrLf
		invoke ExitProcess,0 
	EXIT_PROGRAM ENDP
	; ------------------------------------------------------


	; ---------------------------------------------------
	invalidInstruction PROC
	; this procedure outputs an error message if the user 
	;     fails to input the proper mathematical operator
	;     despite being given a clear list of options...
		MOV		EDX, OFFSET errorMessage
		CALL	CrLf
		CALL	WriteString
		CALL	CrLf
		RET
	invalidInstruction ENDP
	; --------------------------------------------------

main ENDP

end main

