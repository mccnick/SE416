# -------------------- iterative --------------------
def generate_permutations_iterative(input_string):                         
    if not input_string:                                                   # input validation:
        raise ValueError("Input string cannot be empty or None")           
    
    chars = list(input_string)                                             # string is now a **list** of chars
    result = [input_string]                                                # original input_string
    length = len(chars)                                                    # char length of the input string
    swapCounter = [0] * length                                             # count the swaps for each index
    i = 0                                                                 
    
    while i < length:                                                      # iterate all indexes
        if swapCounter[i] < i:                                             # still have swaps left
            if i % 2 == 0:                                                 # Heap's algo: even `i`, swap element 0 with element i   ↓
                chars[0], chars[i] = chars[i], chars[0]                    
            else:                                                          # Heap's algo: odd `i`, swap "swapCounter[i]"" with i
                chars[swapCounter[i]], chars[i] = chars[i], chars[swapCounter[i]] 
            result.append(''.join(chars))                                  # append the newly formed permutation
            swapCounter[i] += 1                                            # increment counter
            i = 0                                                          # restart
        else:                                                              # else, no more swaps left
            swapCounter[i] = 0                                             # reset the counter
            i += 1                                                         # move to next index
    
    return sorted(result)                                                  # return all iterative permutations


# >>>-------------------- recursive --------------------
def generate_permutations_recursive(input_string):                            
    if not input_string:                                                   # input validation:
        raise ValueError("Input string cannot be empty or None")           
    
    def permute(chars, start, result):                                     # helper recursive permute function
        if start == len(chars):                                            # base case
            result.append(''.join(chars))                                  # completed permutation
        else:                                                              # recursive case
            for i in range(start, len(chars)):                             # iterate over every char in `start`
                chars[start], chars[i] = chars[i], chars[start]            #  1. swap current choice into position
                permute(chars[:], start + 1, result)                       #  2. recurse on the *rest* of the string
                chars[start], chars[i] = chars[i], chars[start]            #  3. swap back to restore original ordering
    
    result = []                                                            # empty result list
    permute(list(input_string), 0, result)                                 # recursively generate permutations
    return sorted(result)                                                  # return them


# -------------------- print --------------------
def print_permutations(permutations):                                      # function to print permutations correctly
    for i, perm in enumerate(permutations, 1):                             # enumerate starting from 1 for human‑friendly IDs
        print(f"{i}. {perm}")                                              # output each permutation on its own line


# -------------------- main --------------------
if __name__ == "__main__":                                                 
    try:                                                                   # try
        test_input = "abcd"                                                # permute this string
        print("Iterative Permutations:")                                   
        iterative_result = generate_permutations_iterative(test_input)     # iterative call
        print_permutations(iterative_result)                               
        
        print("\nRecursive Permutations:")                                 
        recursive_result = generate_permutations_recursive(test_input)     # recursive call
        print_permutations(recursive_result)                               
        
    except ValueError as e:                                                # catch validation
        print(f"Error: {e}")                                               # print error

"""
Ouputs:
Iterative Permutations:
1. abcd
2. abdc
3. acbd
4. acdb
5. adbc
6. adcb
7. bacd
8. badc
9. bcad
10. bcda
11. bdac
12. bdca
13. cabd
14. cadb
15. cbad
16. cbda
17. cdab
18. cdba
19. dabc
20. dacb
21. dbac
22. dbca
23. dcab
24. dcba

Recursive Permutations:
1. abcd
2. abdc
3. acbd
4. acdb
5. adbc
6. adcb
7. bacd
8. badc
9. bcad
10. bcda
11. bdac
12. bdca
13. cabd
14. cadb
15. cbad
16. cbda
17. cdab
18. cdba
19. dabc
20. dacb
21. dbac
22. dbca
23. dcab
24. dcba
"""