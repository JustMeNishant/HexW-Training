fname="harry"
lname="potter"
school="hogwards"

#echo $fname  
#echo ${lname}

get_info(){
	echo "$fname $lname goes to $school"
}

echo "$(get_info)"

get_directory(){
	echo "working in $(pwd)"
}

echo "$(get_directory)"

myfunc(){
	return 1; #0: true, 1: false
}

if myfunc; then
	echo "success"
else 
	echo "failure"
fi

#loops: for + while

#traditional for
for((i=0;i<5;i++));do
	echo $i
done

#for-each, range for
for j in {1..5};do
	echo $j
done 


k=1
#while loop
while [ $k -le 5 ];do 
	echo $k
	((k++))
done

#working with Strings : slicing 

name="john" #0:j, 1:o, 2:h, 3:n
echo ${name}
echo ${name:0:2} #jo
echo ${name::2} #jo
echo ${name::-1} #joh
echo ${name:(-2)} #hn

echo ${name/j/J} #substitution - John

#Arrays

cities=('mumbai' 'delhi' 'pune')
echo ${cities[@]} #displays all elements
echo ${cities[0]} #mumbai - first element
echo ${cities[-1]} #pune- last element
echo ${#cities[@]} #3 - total elements
echo ${#cities[0]} #6 - size of 1st element

for((i=0;i<5;i++));do
	echo ${cities[i]}
done

#associative arrays

declare -A cars

cars[swift]="petrol car"
cars[wagonr]="cng car"
cars[ertiga]="cng car"

echo ${cars[@]}
echo ${cars[swift]}


declare -A credentials

credentials[server]="localhost"
credentials[username]="root"
credentials[password]="Password123"

















