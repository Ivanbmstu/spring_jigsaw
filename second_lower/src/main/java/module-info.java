module second.lower{
//    exports lower; split package, any way java.lang.module.ResolutionException:
//    Module second.lower contains package lower, module lower exports package lower to second.lower
    exports lowersecond;
    requires dependent;
}