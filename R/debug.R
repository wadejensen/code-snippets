    r_envs <- search()
    print("R envs: ")
    print(r_envs)

    print("Working directory: ")
    print(getwd())


    print("OS environment variables: ")
    print(Sys.getenv())

    print("R variables: ")
    print(as.list(environment()))
