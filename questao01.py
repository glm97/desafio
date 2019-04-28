def replace(inStr, tam):
    # First we trim the end of list to keep only the
    # string we need to replace the empty spaces.
    n = (len(inStr) - tam) - 1
    inStr.pop(0)
    del inStr[(len(inStr)-n):(len(inStr))]
    # Then we count the ocurrences of empty spaces in the string.
    count = 0
    for c in range(len(inStr)):
        if inStr[c] == ' ':
            count += 1
    # Then we add more slots at the end of the list to hold the additional characters.
    addStr = (count*2)
    for i in range(addStr):
        inStr.append(None)
    # Then we iterate through the end to the begining of the list.
    # We copy the value of two positions behind, until the value of two positions
    # behind equals an empty space. When that happens, we set the current position
    # to value '2', 1 position behind to value '3' and two positions behind to '&'.
    # If the last position in the list is not a null value, we stop, otherwise, we
    # keep iterating backwards through the list until the last value isn't null or
    # we reach the first position in the list.
    position = len(inStr) - 1
    while(position > 0):
            if (inStr[position - 2] == ' '):
                inStr[position] = '2'
                inStr[position-1] = '3'
                inStr[position-2] = '&'
                if(inStr[len(inStr)-1] != None):
                    position = 0
                else:
                    position = len(inStr) - 1
            else:
                inStr[position] = inStr[position - 2]
                position -= 1
        

    finalStr = toString(inStr)
    print(finalStr)

# And this is a method to make the list a string again.
def toString(lista):
    resultado = '';
    for i in lista:
        resultado += i;
    return resultado
    

print('Say something: ')
# We make a list of the string because python doesn't let us change the characters of a string.
inStr = list(input())
tamList = [inStr[(len(inStr)-2)], inStr[(len(inStr)-1)]]
tam = int(toString(tamList))
replace(inStr, tam)
