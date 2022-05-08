def swap_first_and_last_element_in_a_list(user_list):
    user_list_length = len(user_list)
    temp_value = user_list[0]
    user_list[0] = user_list[user_list_length - 1]
    user_list[user_list_length - 1] = temp_value
    return user_list


def input_integer_list():
    # creating an empty list
    input_list = []

    # number of elements as input
    no_of_elements_in_list = int(input("Enter number of elements in the list: "))

    # iterating till the range
    for i in range(0, no_of_elements_in_list):
        list_element = int(input("Enter {} integer element: ".format(i)))

        input_list.append(list_element)  # adding the element

    print("User entered the list {}".format(input_list))
    return input_list


user_int_list = input_integer_list()
user_list_after_swap = swap_first_and_last_element_in_a_list(user_int_list)

print("User's list after swapping the first and last elements {}".format(user_list_after_swap))
